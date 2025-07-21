package com.company.coursereviewapi.repository;

import com.company.coursereviewapi.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewReposiroty extends CrudRepository<Review, Long> {
    List<Review> findByCourseId(Long courseId);

}
