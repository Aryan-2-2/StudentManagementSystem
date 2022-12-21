package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.StudentDTO;
import com.masai.entities.Student;
import com.masai.exception.StudentNotFound;
import com.masai.service.StudentAuthenticationImpl;

@RestController
@RequestMapping("/student")
public class StudentAuthenticationController {

	@Autowired
	private StudentAuthenticationImpl studentAuthentication;
	
	@PostMapping("/authenticate")
	ResponseEntity<Student> studentLogin(@RequestBody StudentDTO studentDTO) throws StudentNotFound{
		       Student student =  studentAuthentication.studentLogin(studentDTO);
		       return new ResponseEntity<Student>(student,HttpStatus.ACCEPTED);
	}
}
