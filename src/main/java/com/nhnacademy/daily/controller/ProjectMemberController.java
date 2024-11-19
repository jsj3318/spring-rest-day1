package com.nhnacademy.daily.controller;

import com.nhnacademy.daily.model.Member;
import com.nhnacademy.daily.model.ProjectMember;
import com.nhnacademy.daily.service.MemberService;
import com.nhnacademy.daily.service.ProjectMemberService;
import com.nhnacademy.daily.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;


    @PostMapping("/projectMembers")
    public ResponseEntity registerMember(
            @RequestBody ProjectMember projectMember
    ) {

        projectMemberService.addProjectMember( projectMember );
        return ResponseEntity.ok().build();
    }

    @GetMapping("/projectMembers/{projectCode}")
    public List<Member> getAllProjectMembers(
            @PathVariable String projectCode
    ) {

        return projectMemberService.getAllProjectMembers(projectCode);
    }

}
