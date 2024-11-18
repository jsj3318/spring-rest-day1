package com.nhnacademy.daily.controller;

import com.nhnacademy.daily.model.Member;
import com.nhnacademy.daily.model.createCommand.MemberCreateCommand;
import com.nhnacademy.daily.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable String id) {
        return memberService.getMember(id);
    }

    @PostMapping("/members")
    public ResponseEntity registerMember(
            @RequestBody MemberCreateCommand memberCreateCommand
    ) {
        Member member = memberService.addMember(
                new Member(
                        memberCreateCommand.getId(),
                        memberCreateCommand.getName(),
                        memberCreateCommand.getAge(),
                        memberCreateCommand.getClazz(),
                        memberCreateCommand.getLocale()
                )
        );

        //TODO member 생성 메신저 알림 보내기

        return ResponseEntity.ok().build();
    }

    @GetMapping("/membersAll")
    public List<Member> getMembers(
        Pageable pageable
    ) {
        return memberService.getAllMembers(pageable).getContent();
    }

}
