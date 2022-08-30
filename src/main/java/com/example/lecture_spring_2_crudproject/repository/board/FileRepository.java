package com.example.lecture_spring_2_crudproject.repository.board;

import com.example.lecture_spring_2_crudproject.entity.board.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
