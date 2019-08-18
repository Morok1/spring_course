package module3.repository;

import module3.model.Project;

import java.util.Optional;

public interface IProjectRepository {
    Optional<Project> findById(Long id);

    Project save(Project project);
}
