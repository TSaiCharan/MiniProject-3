import { useState, useEffect } from "react";
import api from "../services/api";

const useApi = (endpoint) =>{
    const [data, setData] = useState(null);

    useEffect(()=>{
        api(endpoint)
        .then((res) => {
            // console.log(res)
            setData(res);
        })
    },[]);
    return data;
}

export default useApi;