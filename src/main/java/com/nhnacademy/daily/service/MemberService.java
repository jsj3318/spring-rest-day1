package com.nhnacademy.daily.service;

import com.nhnacademy.daily.exception.MemberNotFoundException;
import com.nhnacademy.daily.model.type.ClassType;
import com.nhnacademy.daily.model.type.Locale;
import com.nhnacademy.daily.model.Member;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberService {
    private Map<String, Member> memberMap;

    public MemberService() {
        this.memberMap = new HashMap<>();
        Member member = new Member("baek", "백종원",  50, ClassType.A, Locale.KO);
        memberMap.put(member.getId(), member);
    }

    public Member getMember(String id){
        Member member = memberMap.get(id);
        if(member == null){
            throw new MemberNotFoundException(id + " : 존재하지 않는 멤버 입니다.");
        }
        return member;
    }

    public Member addMember(Member member){
        return memberMap.put(member.getId(), member);
    }

}
