package module1.repository.impl;

import module1.model.Project;
import module1.repository.IProjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IProjectRepositoryImpl implements IProjectRepository {
    private List<Project> projects  = new ArrayList<>();

    @Override
    public Optional<Project> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Project save(Project project) {
        return null;
    }
}
