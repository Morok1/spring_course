package module3.repository.impl;

import lombok.extern.java.Log;
import module3.model.Project;
import module3.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Log
public class IProjectRepositoryImpl implements IProjectRepository {

    @Value("${project.suffix}")
    private String suffix;

    @Value("${project.prefix}")
    private String prefix;

    private List<Project> projects = new ArrayList<>();

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
            logFunc();
            projects.add(project);

            return project;
        } else {
            projects.remove(project);
            projects.add(new Project(project));
            return project;
        }


    }

    private void logFunc(){
        log.info(prefix + suffix);
    }

}
