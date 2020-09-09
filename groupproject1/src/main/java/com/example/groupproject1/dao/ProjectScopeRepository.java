package com.example.groupproject1.dao;
import com.example.groupproject1.model.ProjectScope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProjectScopeRepository extends  JpaRepository<ProjectScope,String> {
    ProjectScope findByItemId(String itemId);
    ProjectScope save(ProjectScope projectScope);
    /*@Transactional
    void deleteByItemId(String itemId);*/

}

