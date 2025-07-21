package com.company.coursereviewapi.service;

import com.company.coursereviewapi.model.Review;
import com.company.coursereviewapi.repository.ReviewReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Review> getReviewsByCourseId(Long courseid) {
        return reviewReposiroty.findByCourseId(courseid);
    }
}
