package com.smagin.module5.converter;

import com.smagin.module5.converter.api.Converter;
import com.smagin.module5.dto.ProjectDto;
import com.smagin.module5.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectConverter implements Converter<Project, ProjectDto> {

    @Override
    public ProjectDto convert(Project project) {
        ProjectDto dto = new ProjectDto();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDate(project.getDate());
        return dto;
    }
}
