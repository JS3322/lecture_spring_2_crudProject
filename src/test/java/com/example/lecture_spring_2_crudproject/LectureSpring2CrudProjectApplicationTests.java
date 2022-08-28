package com.example.lecture_spring_2_crudproject;

import com.example.lecture_spring_2_crudproject.entity.account.Member;
import com.example.lecture_spring_2_crudproject.entity.account.User;
//import com.example.lecture_spring_2_crudproject.entity.board.Post;
import com.example.lecture_spring_2_crudproject.repository.account.MemberRepository;
import com.example.lecture_spring_2_crudproject.repository.account.UserRepository;
//import com.example.lecture_spring_2_crudproject.repository.board.PostRepository;
import com.example.lecture_spring_2_crudproject.service.openAPI.PublicAPI;
import com.example.lecture_spring_2_crudproject.service.textTransfer.TextTransfer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LectureSpring2CrudProjectApplicationTests {

    @Autowired
    TextTransfer textTransfer;

    @Autowired
    PublicAPI publicAPI;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    PostRepository postRepository;

    @Test
    @DisplayName("저장, 데이터가 잘 들어갔는지 확인")
    void contextSave() {
        //Setter로 엔티티를 생성하고 repositoy가 정상 작동하는지 확인
        Member member = new Member();
        member.setId("1kim");
        member.setPassword("1kim123");
        member.setEmail("1kim@123");
        memberRepository.save(member);
    }

    @Test
    void textTest() throws Exception {
        textTransfer.transferText3Word("abcdefg@gmil.com");
    }

    @Test
    void apiTest() {
        publicAPI.testAPI();
    }

//    @Test
//    @BeforeEach
//    void setUp() {
//        userRepository.deleteAll();
//        postRepository.deleteAll();
//
//        System.out.println("==== setUp start ====");
//
//        for(int i = 0; i < 5; i++) {
//            User user = User.builder()
//                    .name("user" + i)
//                    .build();
//
//            userRepository.save(user);
//
//            Post post = Post.builder()
//                    .title("title" + i)
//                    .description("description" + i)
//                    .user(user)
//                    .build();
//
//            postRepository.save(post);
//        }
//        System.out.println("==== setUp end ====");
//
//    }

}
