package com.nhnacademy.daily.service;

import com.nhnacademy.daily.exception.ProjectNotFoundException;
import com.nhnacademy.daily.model.Project;
import com.nhnacademy.daily.model.type.ProjectType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProjectService {
    private final Map<String, Project> projectMap;

    public ProjectService() {
        projectMap = new HashMap<>();
        Project project = new Project("black&white", LocalDate.of(2024, 10, 11), ProjectType.PUBLIC);
        addProject(project);
    }

    public Project getProject(String code) {
        Project project = projectMap.get(code);
        if (project == null) {
            throw new ProjectNotFoundException(code + " : 존재하지 않는 프로젝트 입니다.");
        }
        return project;
    }

    public Project addProject(Project project) {
        return projectMap.put(project.getCode(), project);
    }
}
