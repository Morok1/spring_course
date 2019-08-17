package module1.repository;

import module1.model.Project;

import java.util.Optional;

public interface IProjectRepository {
    Optional<Project> findById(Long id);

    Project save(Project project);
}
