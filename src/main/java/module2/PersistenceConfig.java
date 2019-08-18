package module2;

import module2.repository.impl.IProjectRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class PersistenceConfig {
    @Bean
    public IProjectRepositoryImpl getProjectRepository(){
        return new IProjectRepositoryImpl();
    }
}
