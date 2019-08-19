package com.smagin.module5.service;

import com.smagin.module5.model.Project;
import com.smagin.module5.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectService {
    @Autowired
    private IProjectRepository repository;

    public List<Project> getAllProjects(){
        return repository.findAllByOrOrderByNameDesc();
    }
}
