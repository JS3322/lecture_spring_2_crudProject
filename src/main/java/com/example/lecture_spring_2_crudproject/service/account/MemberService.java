package com.example.lecture_spring_2_crudproject.service.account;


import com.example.lecture_spring_2_crudproject.entity.account.Member;

import java.util.List;

public interface MemberService {

    List<Member> getMemberList();

    void insertMember(Member member);

    Member getMember(Member member);

    void updateMember(Member member);

    void deleteMember(Member Member);
}
