package com.nhnacademy.daily.service;

import com.nhnacademy.daily.model.Locale;
import com.nhnacademy.daily.model.Member;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberService {
    private Map<String, Member> memberMap;

    public MemberService() {
        this.memberMap = new HashMap<>();
        Member member = new Member("baek", "백종원",  50, "A", Locale.KO);
        memberMap.put(member.getId(), member);
    }

    public Member getMember(String id){
        return memberMap.get(id);
    }

    public Member addMember(Member member){
        return memberMap.put(member.getId(), member);
    }

}
