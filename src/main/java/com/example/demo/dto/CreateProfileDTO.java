package com.example.demo.dto;

import com.example.demo.enums.ProfileRole;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateProfileDTO {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String photo;
    @NotNull
    private ProfileRole profileRole;
}
