package com.example.lecture_spring_2_crudproject.repository.board;

import com.example.lecture_spring_2_crudproject.entity.data.FileUploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//FileUploadEntity를 저장하는 인터페이스 (JPA CrudRepository 활용)
public interface FileUploadInfoRepository extends JpaRepository<FileUploadEntity, Long> {

    //findBy : 튜플을 찾겠다
    //BoardSeq : BoardSeq 컬럼에 데이터를 찾겠다
    List<FileUploadEntity> findByBoardSeq(Long boardSeq);


}
