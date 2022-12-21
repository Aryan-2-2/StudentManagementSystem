package com.masai.service;

import java.util.List;

import com.masai.entities.Course;
import com.masai.entities.Student;
import com.masai.exception.CourseNotFound;
import com.masai.exception.NoRecordFound;
import com.masai.exception.StudentNotFound;

public interface StudentServiceIntr {
	public Student updateStudentProfile(Student student)throws StudentNotFound;
	public List<Course> getAssignedCourseByStudentName(String studentName)throws StudentNotFound;
	public List<Course> getAllCourse()throws NoRecordFound;
	public String leaveTheCourse(String studentName, String courseName)throws StudentNotFound,CourseNotFound;
}
