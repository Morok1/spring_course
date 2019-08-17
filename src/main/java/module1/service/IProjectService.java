package module1.service;

import module1.model.Project;

public interface IProjectService {
    Project findById(Long id);

    Project save(Project project);
}
