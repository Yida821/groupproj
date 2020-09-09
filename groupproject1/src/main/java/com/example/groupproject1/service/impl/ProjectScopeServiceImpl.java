package com.example.groupproject1.service.impl;


import com.example.groupproject1.dao.ProjectScopeRepository;
import com.example.groupproject1.model.Project;
import com.example.groupproject1.model.ProjectScope;
import com.example.groupproject1.service.ProjectScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectScopeServiceImpl implements ProjectScopeService {
    @Autowired
    private ProjectScopeRepository projectScopeRepository;

    @Override
    public ProjectScope findByItemId(String itemId) {
        return projectScopeRepository.findByItemId(itemId);
    }

    @Override
    public  ProjectScope saveProjectScope(ProjectScope projectScope){
        return projectScopeRepository.save(projectScope);

    }

    @Override
    public List<ProjectScope> findAll() {
        return projectScopeRepository.findAll();
    }

   /* @Override
   public void deleteByItemId(String itemId){
        projectScopeRepository.deleteByItemId(itemId);
    }*/

}
