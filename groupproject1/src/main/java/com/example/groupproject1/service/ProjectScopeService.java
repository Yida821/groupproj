package com.example.groupproject1.service;
import com.example.groupproject1.model.Project;
import com.example.groupproject1.model.ProjectScope;

import java.util.List;


public interface ProjectScopeService {

    ProjectScope findByItemId(String itemId);
    ProjectScope saveProjectScope(ProjectScope projectScope);
    List<ProjectScope> findAll();
    //void deleteByItemId(String itemId);
}



