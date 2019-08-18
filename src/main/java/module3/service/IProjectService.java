package module3.service;

import module3.model.Project;

public interface IProjectService {
    Project findById(Long id);

    Project save(Project project);
}
