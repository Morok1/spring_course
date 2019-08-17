package module2.service;

import module2.model.Project;

public interface IProjectService {
    Project findById(Long id);

    Project save(Project project);
}
