package com.example.groupproject1.service;

import com.example.groupproject1.model.Project;

import java.util.List;

public interface ProjectService {
    Project findByProjectName(String ProjectNam);
    Project findByProjectCode(int ProjectCode);
    Project saveProject(Project project);
    Project updateProject(Project project);
    List<Project> findAll();
    void deleteByProjectCode(int projectCode);
}
