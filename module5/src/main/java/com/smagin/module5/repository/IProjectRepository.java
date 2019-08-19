package com.smagin.module5.repository;

import com.smagin.module5.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProjectRepository extends JpaRepository<Project, Long> {
    @Override
    Optional<Project> findById(Long aLong);


    @Override
    List<Project> findAll();
}