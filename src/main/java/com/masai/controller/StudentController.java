package com.masai.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Course;
import com.masai.entities.Student;
import com.masai.exception.CourseNotFound;
import com.masai.exception.NoRecordFound;
import com.masai.exception.StudentNotFound;
import com.masai.service.StudentServiceImpl;
import java.util.*;


@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;
	
	
	@PutMapping("/update")
	ResponseEntity<Student> updateStudentProfile(@RequestBody Student student)throws StudentNotFound{
		Student fetched_student = studentService.updateStudentProfile(student);
		return new ResponseEntity<>(fetched_student,HttpStatus.ACCEPTED);
	}
	 
	@GetMapping("/assignedcourses/{studentName}")
	ResponseEntity<java.util.List<Course>> getAssignedCourseByStudentName(@PathVariable String studentName)throws StudentNotFound{
		       java.util.List<Course> courses =  studentService.getAssignedCourseByStudentName(studentName);
	           return new ResponseEntity<>(courses,HttpStatus.OK);
	}
	@GetMapping("/allcourses")
	ResponseEntity<List<Course>>getAllCourse()throws NoRecordFound{
		   List<Course> courses = studentService.getAllCourse();
		   return new ResponseEntity<>(courses,HttpStatus.ACCEPTED);
	}
	 @DeleteMapping("/leavecourse/{studentName}/{courseName}")   
	ResponseEntity<String> leaveTheCourse(@PathVariable String studentName,@PathVariable String courseName)throws StudentNotFound,CourseNotFound{
		      String message = studentService.leaveTheCourse(studentName, courseName);
		      return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
	}
}
