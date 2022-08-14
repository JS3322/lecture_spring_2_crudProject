package com.example.lecture_spring_2_crudproject.repository.account;


import com.example.lecture_spring_2_crudproject.entity.account.Member;
import org.springframework.data.repository.CrudRepository;

//MemberRepository는 CrudRepository를 상속받아 기능을 온전히 씀
//CrudRepository : JPA를 통해 DB에 기본적인 SQL문을 통해 소통 (INSERT INTO, SELECT, UPDATE, DELETE)
public interface MemberRepository extends CrudRepository<Member, Long>{

}
