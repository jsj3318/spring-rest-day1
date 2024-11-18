package com.nhnacademy.daily.service;

import com.nhnacademy.daily.exception.MemberNotFoundException;
import com.nhnacademy.daily.model.type.ClassType;
import com.nhnacademy.daily.model.type.Locale;
import com.nhnacademy.daily.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        if(memberMap.containsKey(member.getId())){
            throw new KeyAlreadyExistsException(member.getId() + " : 이미 존재하는 id 입니다.");
        }
        return memberMap.put(member.getId(), member);
    }

    public Page<Member> getAllMembers(Pageable pageable){
        List<Member> memberList = new ArrayList<>(memberMap.values());

        int start = (int)pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), memberList.size());

        List<Member> pagedProjects = (start <= end) ? memberList.subList(start, end) : new ArrayList<>();

        return new PageImpl<>(pagedProjects, pageable, memberList.size());
    }

}
