package com.company.coursereviewapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String instructor;
    private Double averageRating;
}
