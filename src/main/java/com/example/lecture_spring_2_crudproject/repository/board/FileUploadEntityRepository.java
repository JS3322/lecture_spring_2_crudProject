package com.example.lecture_spring_2_crudproject.repository.board;

import com.example.lecture_spring_2_crudproject.entity.data.FileUploadEntity;
import org.springframework.data.repository.CrudRepository;

public interface FileUploadEntityRepository extends CrudRepository<FileUploadEntity, Long> {
}
