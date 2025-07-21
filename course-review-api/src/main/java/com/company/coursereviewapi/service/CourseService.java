package com.company.coursereviewapi.service;

import com.company.coursereviewapi.dto.CourseResponseDTO;
import com.company.coursereviewapi.model.Course;
import com.company.coursereviewapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<CourseResponseDTO> getAllCourses() {
//        return (List<Course>) courseRepository.findAllWithRating();
        return courseRepository.findAllWithRating();
    }

    public Course getCourseById(long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }
}
