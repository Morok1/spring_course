package com.smagin.module5.controller;

import com.smagin.module5.model.Project;
import com.smagin.module5.service.ProjectService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log
public class ProjectController {

    @Autowired
    private ProjectService service;


    @GetMapping("/projects")
    public List<Project> getProjects(){
        return service.getAllProjects();
    }


}
