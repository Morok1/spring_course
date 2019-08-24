package integration;

import com.smagin.module5.model.Project;
import com.smagin.module5.repository.IProjectRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class IProjectRepositoryTest {
    @Autowired
    private IProjectRepository repository;

    @Test
    public void whenSavingNewProject_thenSuccess() {
        Project newProject = new Project(6L,"name" ,  LocalDate.now());

        assertNotNull(repository.save(newProject));
    }



}
