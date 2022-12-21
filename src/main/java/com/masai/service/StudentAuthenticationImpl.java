package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.StudentDTO;
import com.masai.entities.Student;
import com.masai.exception.StudentNotFound;
import com.masai.repository.StudentRepository;

@Service
public class StudentAuthenticationImpl implements StudentAuthenticationIntr {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student studentLogin(StudentDTO studentDTO) throws StudentNotFound {
		Optional<Student> check_code =  studentRepository.findById(studentDTO.getStudentCode()); 
		if(check_code.isEmpty()) {
			throw new StudentNotFound(" given student code is worong : " +studentDTO.getStudentCode());
		}
		
	   Optional<Student> check_dob = studentRepository.findByDateOfBirth(studentDTO.getDateOfBirth());
	   if(check_dob.isEmpty()) {
		throw new StudentNotFound("given date of birth is wrong : " + studentDTO.getDateOfBirth());
	}
	   return check_code.get();
	}
}
