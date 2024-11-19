package com.nhnacademy.daily.service;

import com.nhnacademy.daily.exception.MemberNotFoundException;
import com.nhnacademy.daily.model.dooray.MessagePayload;
import com.nhnacademy.daily.model.type.ClassType;
import com.nhnacademy.daily.model.type.Locale;
import com.nhnacademy.daily.model.Member;
import com.nhnacademy.daily.model.type.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private DooraySendClient dooraySendClient;
    private RedisTemplate<String, Object> redisTemplate;

    private String HASH_NAME = "Member:";


    public MemberService(DooraySendClient dooraySendClient, RedisTemplate<String, Object> redisTemplate) {
        this.dooraySendClient = dooraySendClient;
        this.redisTemplate = redisTemplate;
        Member member = new Member("baek", "1234", "백종원",  50, ClassType.A, Locale.KO, Role.ADMIN);
        redisTemplate.opsForHash().put(HASH_NAME,"baek", member);
    }

    public Member getMember(String id){
        Member member = (Member) redisTemplate.opsForHash().get(HASH_NAME, id);
        if(member == null){
            throw new MemberNotFoundException(id + " : 존재하지 않는 멤버 입니다.");
        }
        return member;
    }

    public Member addMember(Member member){
        if(redisTemplate.opsForHash().hasKey(HASH_NAME, member.getId())){
            throw new KeyAlreadyExistsException(member.getId() + " : 이미 존재하는 id 입니다.");
        }

        redisTemplate.opsForHash().put(HASH_NAME, member.getId(), member);

        // 두레이에 알림 보내기
        // https://hook.dooray.com/services/3204376758577275363/3939383629139110347/6GoYNd1QT2SBd1DXke0Yrg
        MessagePayload messagePayload = new MessagePayload("유저 등록 알림",
                member.getName() + "(" + member.getId() + ") 유저 등록 됨");
        dooraySendClient.sendMessage(messagePayload, 3204376758577275363L, 3939383629139110347L, "6GoYNd1QT2SBd1DXke0Yrg");

        return member;
    }

    public Page<Member> getAllMembers(Pageable pageable){
        List<Object> objectList = new ArrayList<>(redisTemplate.opsForHash().values(HASH_NAME));

        List<Member> memberList = objectList.stream()
                .filter(Member.class::isInstance)
                .map(Member.class::cast)
                .toList();


        int start = (int)pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), memberList.size());

        List<Member> pagedProjects = (start <= end) ? memberList.subList(start, end) : new ArrayList<>();

        return new PageImpl<>(pagedProjects, pageable, memberList.size());
    }

    public boolean isExist(String id){
        return redisTemplate.opsForHash().hasKey(HASH_NAME, id);
    }

}
