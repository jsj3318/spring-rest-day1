package com.nhnacademy.daily.service;

import com.nhnacademy.daily.model.Member;
import com.nhnacademy.daily.model.ProjectMember;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProjectMemberService {
    private final ProjectService projectService;
    private final MemberService memberService;
    private Set<ProjectMember> projectMemberSet;

    public ProjectMemberService(ProjectService projectService, MemberService memberService) {
        this.projectService = projectService;
        this.memberService = memberService;
        projectMemberSet = new HashSet<>();
    }

    public void addProjectMember(ProjectMember projectMember) {
        if(!memberService.isExist(projectMember.getMemberId()) ||
                !projectService.isExist(projectMember.getProjectCode())) {
            throw new IllegalArgumentException("존재하지 않는 멤버 id 또는 프로젝트 코드!");
        }
        projectMemberSet.add(projectMember);
    }

    public List<Member> getAllProjectMembers(String projectCode) {
        if(!projectService.isExist(projectCode)) {
            throw new IllegalArgumentException("존재하지 않는 프로젝트 코드!");
        }

        // 멤버 id 담겨있는 리스트
        List<String> idList = projectMemberSet.stream()
                .filter(projectMember -> projectMember.getProjectCode().equals(projectCode))
                .map(ProjectMember::getMemberId)
                .toList();

        List<Member> memberList = new ArrayList<>();
        for(String id : idList) {
            memberList.add(memberService.getMember(id));
        }

        return memberList;
    }

}
