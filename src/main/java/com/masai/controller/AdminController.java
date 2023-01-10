package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Course;
import com.masai.entities.Student;
import com.masai.exception.CourseAlreadyExists;
import com.masai.exception.CourseNotFound;
import com.masai.exception.NoRecordFound;
import com.masai.exception.StudentAlreadyExists;
import com.masai.exception.StudentNotFound;
import com.masai.service.AdminServiceImp;

@RestController
@RequestMapping("/admin")
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class AdminController {

	@Autowired
	private AdminServiceImp adminService;
	

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/hello")
	ResponseEntity<String> sayHello() throws StudentAlreadyExists{
		   String message =  "hello";
		   return new ResponseEntity<>(message,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/admit/student")
	ResponseEntity<String> admitStudent(@Valid @RequestBody Student student) throws StudentAlreadyExists{
		   String message =  adminService.admitStudent(student);
		   return new ResponseEntity<>(message,HttpStatus.CREATED);
	}
	
	@PostMapping("/upload/course")
	ResponseEntity<String> uploadCourseDetails(@Valid @RequestBody Course course) throws CourseAlreadyExists{
		   String message =  adminService.uploadCourseDetails(course);
		   return new ResponseEntity<>(message,HttpStatus.CREATED);
	}
	@PostMapping("/assign/{studentCode}/{courseName}")
	ResponseEntity<String> assignCourseToStudent(@Valid @PathVariable Integer studentCode,@PathVariable String courseName) throws StudentNotFound, CourseNotFound{
		   String message =  adminService.assignCourseToStudent(studentCode, courseName);
		   return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
	}
	@GetMapping("/student/{studentName}")
	ResponseEntity<Student> getStudentDetailsByStudentName(@PathVariable String studentName) throws StudentNotFound{
		   Student student =  adminService.getStudentDetailsByStudentName(studentName);
		   return new ResponseEntity<>(student,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/students/{courseName}")
	ResponseEntity<List<Student>> getStudentsByCourseName(@PathVariable String courseName)throws CourseNotFound, NoRecordFound{
		   List<Student> students =  adminService.getStudentsByCourseName(courseName);
		   return new ResponseEntity<>(students,HttpStatus.ACCEPTED);
	}
}
