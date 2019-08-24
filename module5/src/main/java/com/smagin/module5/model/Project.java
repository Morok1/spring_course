package com.smagin.module5.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "PROJECT")
@Data
@AllArgsConstructor
public class Project {
    @Id
    @Column(name="ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "DATE")
    private LocalDate date;

}
