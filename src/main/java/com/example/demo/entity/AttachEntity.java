package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "attach")
@Entity
public class AttachEntity {
    @Id
    private String id;
    @Column(name = "original_name")
    private String originalName;
    @Column(name = "size")
    private Long size;
    @Column(name = "extension")
    private String extension;
    @Column(name = "path")
    private String path;
    @Column(name = "url")
    private String url;
    @Column(name = "duration")
    private Long duration;
    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

}
