package com.nhnacademy.daily.service;

import com.nhnacademy.daily.exception.ProjectNotFoundException;
import com.nhnacademy.daily.model.Project;
import com.nhnacademy.daily.model.type.ProjectType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        if(projectMap.containsKey(project.getCode())) {
            throw new KeyAlreadyExistsException(project.getCode() + " : 이미 존재하는 code 입니다.");
        }
        return projectMap.put(project.getCode(), project);
    }

    public Page<Project> getAllProjects(Pageable pageable) {
        List<Project> projectList = new ArrayList<>(projectMap.values());

        int start = (int)pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), projectList.size());

        List<Project> pagedProjects = (start <= end) ? projectList.subList(start, end) : new ArrayList<>();

        return new PageImpl<>(pagedProjects, pageable, projectList.size());
    }

}
