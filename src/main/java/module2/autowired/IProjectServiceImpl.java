package module2.autowired;

import module1.model.Project;
import module1.repository.IProjectRepository;
import module2.repository.impl.IProjectRepositoryImpl;

import java.util.Optional;

public class IProjectServiceImpl implements IProjectRepository{
    private IProjectRepositoryImpl repository;

    public IProjectServiceImpl(IProjectRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Project save(Project project) {
        return null;
    }
}
