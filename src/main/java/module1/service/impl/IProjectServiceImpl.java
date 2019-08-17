package module1.service.impl;

import module1.repository.IProjectRepository;
import module1.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectRepository repository;



}
