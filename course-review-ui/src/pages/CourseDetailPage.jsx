import { useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";
import useCourseDetails from "../hooks/useCourseDetails"; 
import {useUser} from "../context/AuthContext";
import "./CourseDetailPage.css";

const CourseDetailPage = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const course = useCourseDetails(`/courses/${id}`);
    const { user, setUser, users, login, logout } = useUser();
    const openReviews = () => {
        navigate(`/courses/${course.id}/reviews`);
    }
    if (!course) {
        return <p>Loading...</p>; // Avoid trying to read properties of null
    }

    return (
        <div className="course-detail-container">
            {
                user ? (
                    <div>
                        <h1 className="course-detail-title">{course.title}</h1>
                        <p className="course-detail-description">{course.description}</p>
                        <p className="course-detail-instructor"><strong>Instructor:</strong> {course.instructor}</p>
                        <button className="details-button" onClick = {openReviews}>View Reviews</button>
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

export default CourseDetailPage;
