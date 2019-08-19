package com.smagin.module5.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "Project")
@Data
public class Project {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String name;

    private LocalDate date;

}
