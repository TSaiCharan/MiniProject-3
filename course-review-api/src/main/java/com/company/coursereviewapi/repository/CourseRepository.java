package com.company.coursereviewapi.repository;

import com.company.coursereviewapi.dto.CourseResponseDTO;
import com.company.coursereviewapi.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

//    @Query(value = "SELECT c.id as id, c.title as title, c.description as description, c.instructor as instructor, 0.0 as averageRating FROM Course c")
//    @Query("SELECT new com.company.coursereviewapi.dto.CourseResponseDTO(c.id, c.title, c.description, c.instructor, 0.0) FROM Course c")
    @Query("SELECT new com.company.coursereviewapi.dto.CourseResponseDTO(c.id, c.title, c.description, c.instructor, AVG(r.rating)) " +
            "FROM Course c LEFT JOIN c.reviews r GROUP BY c.id, c.title, c.description, c.instructor")
    List<CourseResponseDTO> findAllWithRating();
}
