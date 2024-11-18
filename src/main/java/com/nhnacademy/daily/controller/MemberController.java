package com.nhnacademy.daily.controller;

import com.nhnacademy.daily.model.Member;
import com.nhnacademy.daily.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable String id) {
        Member member = memberService.getMember(id);
        return member;
    }
    
}
