import { useParams } from "react-router-dom";
import useApi from "../../hooks/useApi";
import {useUser} from "../../context/AuthContext";

import "./Review.css";

const Review = () => {
  const { id } = useParams();
  const { user, setUser, users, login, logout } = useUser();
  const reviews = useApi(`/reviews/${id}`);
  
  if (!reviews) {
    return <p>Loading...</p>;
  }

  return (
    <div className="reviews-page">
      {
        user ?(
          <div>
            <h2>Course Reviews</h2>
              {reviews.length > 0 ? (
                reviews.map((review) => (
                  <div key={review.id} className="review-card">
                    <p className="review-text">"{review.text}"</p>
                    <p className="review-rating">Rating: ⭐ {review.rating}</p>
                    {review.user && <p className="review-user">By: {review.user.name}</p>}
                  </div>
                ))
              ) : (
                <p>No reviews yet for this course.</p>
            )}
          </div>
        ):(
          <div className="nouser">
            login first
          </div>
        )
      }
    </div>
  );
};

export default Review;