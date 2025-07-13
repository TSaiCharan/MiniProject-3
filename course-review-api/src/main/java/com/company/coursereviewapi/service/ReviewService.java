package com.company.coursereviewapi.service;

import com.company.coursereviewapi.model.Review;
import com.company.coursereviewapi.repository.ReviewReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewReposiroty reviewReposiroty;

    public void addReview(Review review) {
        reviewReposiroty.save(review);

    }

    public void delete(Long id) {
        reviewReposiroty.deleteById(id);
    }
}
