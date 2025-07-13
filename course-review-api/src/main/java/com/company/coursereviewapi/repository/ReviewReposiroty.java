package com.company.coursereviewapi.repository;

import com.company.coursereviewapi.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewReposiroty extends CrudRepository<Review, Long> {
}
