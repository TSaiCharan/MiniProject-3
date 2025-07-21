package com.company.coursereviewapi.controller;

import com.company.coursereviewapi.dto.ReviewRequestDTO;
import com.company.coursereviewapi.dto.ReviewResponseDTO;
import com.company.coursereviewapi.model.Course;
import com.company.coursereviewapi.model.Review;
import com.company.coursereviewapi.model.User;
import com.company.coursereviewapi.service.CourseService;
import com.company.coursereviewapi.service.ReviewService;
import com.company.coursereviewapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173")
public class ReviewController {

    @Autowired
    ReviewService reviewService;
    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;

    @GetMapping("reviews/{courseid}")
    public List<Review> getReviews(@PathVariable Long courseid){
        return reviewService.getReviewsByCourseId(courseid);
    }

    @PostMapping("courses/{courseId}/reviews")
    public String addNewReview(@PathVariable(name = "courseId") Long id, @RequestBody ReviewRequestDTO reviewRequestDTO){

        Course course = courseService.getCourseById(id);
        User user = userService.findById(reviewRequestDTO.getUserId());

        Review review = new Review();

        review.setText(reviewRequestDTO.getText());
        review.setRating(reviewRequestDTO.getRating());
        review.setCourse(course);
        review.setUser(user);

        reviewService.addReview(review);

        return "Add New Review";
    }

    @DeleteMapping("reviews/{id}")
    public String deleteReview(@PathVariable Long id){
        reviewService.delete(id);
        return "Deleted Review";
    }

}
