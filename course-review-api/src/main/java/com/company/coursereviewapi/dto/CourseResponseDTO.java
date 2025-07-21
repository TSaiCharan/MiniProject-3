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

    public CourseResponseDTO(){}

    public CourseResponseDTO(Long id, String title, String description, String instructor, Double averageRating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.averageRating = averageRating;
    }

}
