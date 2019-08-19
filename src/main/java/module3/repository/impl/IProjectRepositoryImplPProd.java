package module3.repository.impl;

import lombok.extern.java.Log;
import module3.model.Project;
import module3.repository.IProjectRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Profile("prod")
@Log
@Repository
public class IProjectRepositoryImplPProd implements IProjectRepository {

    @Override
    public Optional<Project> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Project save(Project project) {
        return null;
    }
}
