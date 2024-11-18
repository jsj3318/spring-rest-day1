package com.nhnacademy.daily.controller;

import com.nhnacademy.daily.model.Project;
import com.nhnacademy.daily.model.createCommand.ProjectCreateCommand;
import com.nhnacademy.daily.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/projects/{code}")
    public Project getProject(@PathVariable String code) {
        Project project = projectService.getProject(code);
        return project;
    }

    @PostMapping("/projects")
    public ResponseEntity createProject(
            @RequestBody ProjectCreateCommand projectCreateCommand
    ) {
        Project project = projectService.addProject(
                new Project(
                        projectCreateCommand.getCode(),
                        projectCreateCommand.getLocalDate(),
                        projectCreateCommand.getType()
                )
        );
        return ResponseEntity.ok().build();
    }

}
