package com.smagin.module5.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ProjectDto {
    private Long id;

    private String name;

    private LocalDate date;
}
