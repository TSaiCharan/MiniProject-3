import { useNavigate } from "react-router-dom";
import "./CourseCard.css";
import React from "react";

const CourseCard = ({ course }) => {

  const navigate = useNavigate();
    
  const openDetails = () =>{
    navigate(`/courses/${course.id}/details`);
  }

  const openReviews = () => {
    navigate(`/courses/${course.id}/reviews`);
  }

  const openReviewForm = (e) =>{
    console.log(course.id)
    navigate(`/courses/${course.id}/reviewform`);
  }

  return (
    <div className="course-card" id={course.id}>
        <h2 className="course-title">{course.title}</h2>
        <p className="course-description">{course.description}</p>
        <p className="course-instructor">Instructor: {course.instructor}</p>
        <p className="course-rating">Average Rating: ⭐ {course.averageRating}</p>
        <button className="details-button" onClick = {openDetails}>View Details</button><br></br>
        <button className="details-button" onClick = {openReviews}>View Reviews</button><br></br>
        <button className="details-button" onClick = {openReviewForm}>Add Review</button>
    </div>
  );
};

export default React.memo(CourseCard);