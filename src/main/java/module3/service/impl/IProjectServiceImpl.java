package module3.service.impl;

import module3.model.Project;
import module3.repository.IProjectRepository;
import module3.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IProjectServiceImpl implements IProjectService {
    @Autowired
    private IProjectRepository repository;

    @Override
    public Project findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Project save(Project project) {
        return repository.save(project);
    }
}
