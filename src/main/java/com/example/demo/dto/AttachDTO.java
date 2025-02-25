package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class AttachDTO {
    private String id;
    private String originalName;
    private Long size;
    private String extension;
    private String path;
    private Long duration;
    private String url;
    private LocalDateTime createdData;
}
