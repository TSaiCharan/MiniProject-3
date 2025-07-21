import { useState, useEffect } from "react";
import api from "../services/api";

const useCourseDetails = (endpoint) =>{

    const [courses, setCourses] = useState(null);

    useEffect(()=>{

        api(endpoint)
        .then((res) => {
            // console.log(res);
            setCourses(res)
        })
        .catch((err) => {
            console.log(err);
        })
    })

    return courses;
}

export default useCourseDetails;