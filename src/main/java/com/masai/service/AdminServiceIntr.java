package com.masai.service;

import java.util.List;

import com.masai.entities.Course;
import com.masai.entities.Student;
import com.masai.exception.CourseAlreadyExists;
import com.masai.exception.CourseNotFound;
import com.masai.exception.NoRecordFound;
import com.masai.exception.StudentAlreadyExists;
import com.masai.exception.StudentNotFound;

public interface AdminServiceIntr {
	public String admitStudent(Student student)throws StudentAlreadyExists;
	public String uploadCourseDetails(Course course)throws CourseAlreadyExists;
	public String assignCourseToStudent(Integer studentCode, String courseName)throws StudentNotFound,CourseNotFound;
    public Student getStudentDetailsByStudentName(String studentName)throws StudentNotFound;
    public List<Student> getStudentsByCourseName(String courseName)throws CourseNotFound, NoRecordFound; 
}
