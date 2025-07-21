import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./ReviewForm.css";
import {useUser} from "../../context/AuthContext";
// import useApi from "../../hooks/useApi";
import api from "../../services/api"
import { useParams } from "react-router-dom";

const ReviewForm = () => {
    const [rating, setRating] = useState(0);
    const { id } = useParams();
    const [text, setText] = useState("");
    const { user, setUser, users, login, logout } = useUser();
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        console.log(user.id);
        e.preventDefault();
        if (rating === 0 || text.trim() === "") {
            alert("Please fill in all fields.");
            return;
        }

        console.log(id);

        const reviewData = {
            rating,
            text,
            userId: id
        };

        try{
          api(`/courses/${id}/reviews`, {
              method: "POST",
              body: JSON.stringify(reviewData),
          });
          navigate(`/`);
          setRating(0);
          setText("");
        } catch(err){
          console.log(err);
        }
    };

  return (
    <form className="review-form" onSubmit={handleSubmit}>
      <h2>Add a Review</h2>

      <label htmlFor="rating">Rating (1-5):</label>
      <input
        type="number"
        id="rating"
        name="rating"
        min="1"
        max="5"
        value={rating}
        onChange={(e) => setRating(Number(e.target.value))}
      />

      <label htmlFor="text">Review:</label>
      <textarea
        id="text"
        name="text"
        rows="4"
        placeholder="Write your review..."
        value={text}
        onChange={(e) => setText(e.target.value)}
      ></textarea>

      <button type="submit">Submit Review</button>
    </form>
  );
};

export default ReviewForm;
