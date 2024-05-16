package com.example.demo.service;

import com.example.demo.dto.CreateProfileDTO;
import com.example.demo.dto.ProfileDTO;
import com.example.demo.entity.ProfileEntity;
import com.example.demo.enums.ProfileStatus;
import com.example.demo.exp.AppBadException;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.util.JWTUtil;
import com.example.demo.util.MDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public ProfileDTO createProfile(CreateProfileDTO dto){
        Optional<ProfileEntity > optional=profileRepository.getByEmail(dto.getEmail());
        if (optional.isPresent()){
            throw new AppBadException("email exist");
        }
        ProfileEntity profileEntity=profileRepository.save(toEntity(dto));
        return toDTO(profileEntity);

    }

    public ProfileEntity toEntity(CreateProfileDTO dto){
        ProfileEntity entity=new ProfileEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setRole(dto.getProfileRole());
        entity.setEmail(dto.getEmail());
        entity.setPassword(MDUtil.encode(dto.getPassword()));
        entity.setStatus(ProfileStatus.ACTIVE);
        entity.setPhotoId(dto.getPhoto());
        return entity;
    }

    public ProfileDTO toDTO (ProfileEntity entity){
        ProfileDTO dto=new ProfileDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setRole(entity.getRole());
        dto.setEmail(entity.getEmail());
        dto.setJwt(JWTUtil.encode(entity.getId(), entity.getRole()));
        return dto;
    }
}
