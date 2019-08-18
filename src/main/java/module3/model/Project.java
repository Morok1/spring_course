package module3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
    private Long id;
    private String name;


    public Project(Project project) {
        this(project.getId(), project.getName());

    }
}
