package module1.repository.impl;

import module1.model.Project;
import module1.repository.IProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class IProjectRepositoryImpl implements IProjectRepository {
    private List<Project> projects  = new ArrayList<>();

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(s -> s.getId() == id).findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = projects
                .stream()
                .filter(s -> s.equals(project))
                .findFirst().orElse(null);

        if (existingProject == null) {
            projects.add(project);

            return project;
        } else {
            projects.remove(project);
            projects.add(new Project(project));
        }


        projects.add(project);
        return project;
    }
}
