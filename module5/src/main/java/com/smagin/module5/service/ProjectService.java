package com.smagin.module5.service;

import com.smagin.module5.converter.ProjectConverter;
import com.smagin.module5.dto.ProjectDto;
import com.smagin.module5.repository.IProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProjectService {
    private ProjectConverter converter;
    private IProjectRepository repository;

    public ProjectService(ProjectConverter converter, IProjectRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    public List<ProjectDto> getAllProjects(){
        return repository
                .findAllByOrOrderByNameDesc()
                .stream()
                .map(s->converter.convert(s))
                .collect(Collectors.toList());
    }
}
