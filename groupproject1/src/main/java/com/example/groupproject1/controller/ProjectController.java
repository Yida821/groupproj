package com.example.groupproject1.controller;

import com.example.groupproject1.model.Project;
import com.example.groupproject1.model.ProjectResource;
import com.example.groupproject1.model.Resource;
import com.example.groupproject1.model.User;
import com.example.groupproject1.service.ProjectService;
import com.example.groupproject1.service.ResourceService;
import com.example.groupproject1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/getAll")
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/getProjectByCode")
    public Project getProjectByCode(int projectCode) {
        return projectService.findByProjectCode(projectCode);
        //.orElseThrow(() -> new ResourceNotFoundException("resource", "id", code));
    }

    @GetMapping(value = "/getProjectByName")
    public Project findByProjectname(String projectName) {
        return projectService.findByProjectName(projectName);
    }


    @PostMapping("/add")
    public Project addProject(@RequestParam("projectCode") int projectCode
            , @RequestParam("projectName") String projectName, @RequestParam("userId") int userId) {

        Project proj = new Project();
        proj.setProjectCode(projectCode);
        proj.setProjectName(projectName);
        User user = userService.findById(userId);
        proj.setUser(user);
        return projectService.saveProject(proj);
    }



    @PutMapping("/updateProjectByCode")
    public Project updateProjectByCode(int projectCode, String projectName, int userId) {
        Project proj = projectService.findByProjectCode(projectCode);
        proj.setProjectName(projectName);
        User user = userService.findById(userId);
        proj.setUser(user);
        return projectService.updateProject(proj);
    }

    @PutMapping("/addResource")
    public Project addResource(@RequestParam("projectCode") int projectCode,
                               @RequestParam("resourceCode") int resourceCode) {

        Project project = projectService.findByProjectCode(projectCode);
        Resource resource = resourceService.findByResourceCode(resourceCode);
        if (resource != null && project != null){
            List list = project.getProjectResource();
            ProjectResource newProjRes = new ProjectResource(project, resource);
            list.add(newProjRes);
        }
        return projectService.updateProject(project);
    }

    @Transactional
    @DeleteMapping("/deleteProjectByCode")
    public ResponseEntity<?> deleteProjectByCode(int projectCode) {

        projectService.deleteByProjectCode(projectCode);

        return ResponseEntity.ok().build();
    }
}
