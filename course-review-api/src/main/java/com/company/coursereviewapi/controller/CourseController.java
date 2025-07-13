package com.company.coursereviewapi.controller;

import com.company.coursereviewapi.dto.CourseResponseDTO;
import com.company.coursereviewapi.model.Course;
import com.company.coursereviewapi.model.Review;
import com.company.coursereviewapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("courses")
    public List<CourseResponseDTO> getAllCourses(){
        List<Course> courses = courseService.getAllCourses();
        return courses.stream().map(this::convertToCourseResponseDTO).collect(Collectors.toList());
    }
    
    @GetMapping("courses/{id}")
    public Course getCourseById(@PathVariable long id){
        return courseService.getCourseById(id);
    }

    private CourseResponseDTO convertToCourseResponseDTO(Course course){
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setId(course.getId());
        courseResponseDTO.setTitle(course.getTitle());
        courseResponseDTO.setDescription(course.getDescription());
        courseResponseDTO.setInstructor(course.getInstructor());

        double average = 0;
        int count = 0;
        for(Review review : course.getReviews()){
            count++;
            average += review.getRating();
        }
        if(count !=0) average /= count;

        courseResponseDTO.setAverageRating(average);
        return courseResponseDTO;
    }
}