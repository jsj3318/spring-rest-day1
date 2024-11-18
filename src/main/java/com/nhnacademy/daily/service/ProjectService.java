package com.nhnacademy.daily.service;

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
        return projectMap.get(code);
    }

    public Project addProject(Project project) {
        return projectMap.put(project.getCode(), project);
    }
}
