package com.example.demo.repository;

import com.example.demo.entity.ProfileEntity;
import com.example.demo.enums.ProfileStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface ProfileRepository extends CrudRepository<ProfileEntity,Integer> {
    Optional<ProfileEntity>findByEmail(String username);


    @Query("from ProfileEntity where email=?1 and visible=true ")
    Optional<ProfileEntity> getByEmail(String email);

    @Transactional
    @Modifying
    @Query("Update ProfileEntity  set status =?2 where id = ?1")
    void updateStatus(Integer id, ProfileStatus active);

    @Query(value = "SELECT * FROM profile WHERE email=?1 AND password=?2 AND visible=true AND status='ACTIVE' ", nativeQuery = true)
    Optional<ProfileEntity> getProfile(String email, String password);

    @Query("FROM ProfileEntity WHERE id=?1 AND  visible=true ")
    Optional<ProfileEntity> getById(Integer id);


}
