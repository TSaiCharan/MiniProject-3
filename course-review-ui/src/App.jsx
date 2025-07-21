import { BrowserRouter, Routes, Route } from "react-router-dom";

import './App.css';
import AuthProvider from './context/AuthContext';
import Navbar from "./components/Navbar/Navbar"
import CourseList from "./components/CourseList/CourseList"
import CourseDetailPage from "./pages/CourseDetailPage"
import Review from "./components/ReviewList/Review"
import ReviewForm from "./components/ReviewForm/ReviewForm";

function App() {
  return (
    <AuthProvider className="body">
      <div>
        <Navbar/>
      </div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<CourseList/>}/> 
          <Route path="/courses/:id/details" element={<CourseDetailPage/>}/> 
          <Route path="/courses/:id/reviews" element={<Review/>}/> 
          <Route path="/courses/:id/reviewform" element={<ReviewForm/>}/> 
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  );
}

export default App;
