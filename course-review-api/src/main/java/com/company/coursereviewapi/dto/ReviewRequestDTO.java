package com.company.coursereviewapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequestDTO {
    private String text;
    private Integer rating;
    private Long userId;
}
