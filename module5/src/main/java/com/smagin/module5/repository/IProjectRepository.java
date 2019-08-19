package com.smagin.module5.repository;

import com.smagin.module5.model.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface IProjectRepository extends PagingAndSortingRepository<Project, Long> {
    @Override
    Optional<Project> findById(Long aLong);

    @Query("select p from  Project p where p.name like %?1%")
    List<Project> findByNameMatches(String name);

    List<Project> findAllByOrOrderByNameDesc();
}