package com.example.lecture_spring_2_crudproject;

import com.example.lecture_spring_2_crudproject.entity.account.Member;
import com.example.lecture_spring_2_crudproject.repository.account.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class LectureSpring2CrudProjectApplicationTests {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("저장, 전체조회하여 데이터가 잘 들어갔는지 확인")
    void contextLoads() {
        Member member = new Member();
        member.setId("1123");
        member.setPassword("1123");
        member.setEmail("1123@123");
        memberRepository.save(member);
    }

}
