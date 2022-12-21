package com.masai.service;

import com.masai.DTO.StudentDTO;
import com.masai.entities.Student;
import com.masai.exception.StudentNotFound;

public interface StudentAuthenticationIntr {

	public Student studentLogin(StudentDTO studentDTO)throws StudentNotFound;

}
