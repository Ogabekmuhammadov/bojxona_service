package com.example.demo.dto;

import com.example.demo.enums.ProfileRole;
import com.example.demo.enums.ProfileStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
public class ProfileDTO {

    protected Integer id;
    private String name;
    private String surname;
    private String email;
    private String tempEmail;
    private String password;
    private String photo;
    private AttachDTO photos;
    private AttachDTO attach;
    private ProfileStatus status;
    private ProfileRole role;
    protected LocalDateTime createdDate;
    protected LocalDateTime updatedDate;
    private Boolean visible;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String jwt;
}
