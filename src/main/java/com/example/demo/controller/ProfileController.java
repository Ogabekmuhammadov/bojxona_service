package com.example.demo.controller;

import com.example.demo.dto.CreateProfileDTO;
import com.example.demo.service.ProfileService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Profile Api list ", description = "Api list for Profile ")
@RestController
@RequestMapping("/profile")
@Slf4j
public class ProfileController {
    @Autowired
    ProfileService profileService;

    public ResponseEntity<?> createProfile(@Valid @RequestBody CreateProfileDTO dto) {
        return ResponseEntity.ok(profileService.createProfile(dto));
    }
}
