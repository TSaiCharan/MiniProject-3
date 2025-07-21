import AuthProvider from "../../context/AuthContext";
import {useUser} from "../../context/AuthContext";
import "./CourseList.css"
import CourseCard from "../CourseCard/CourseCard"

import useCourseDetails  from "../../hooks/useCourseDetails";

const CourseList = () =>{

    const { user, setUser, users, login, logout } = useUser();
    let courses = useCourseDetails("/courses");

    return(
        <div className="courselistbody">
            {
                user ?(
                    <div className="list">
                        {

                            courses ?(
                                courses.map(c=>(
                                    <CourseCard key={c.id} course={c}/>
                                ))
                            ):(
                                <p>Loading courses</p>
                            )

                        }
                    </div>
                ):(
                    <div className="nouser">
                        login first
                    </div>
                )
            }
        </div>
    )
}

export default CourseList;