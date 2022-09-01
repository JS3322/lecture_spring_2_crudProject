package com.example.lecture_spring_2_crudproject.entity.board;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FileEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String uuid;

    private String contentType;

    private String name;

    private String originalFilename;


}
