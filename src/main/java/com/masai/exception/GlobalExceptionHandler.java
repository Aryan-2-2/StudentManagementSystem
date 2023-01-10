package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserAlreadyExists.class)
	ResponseEntity<MyErrorDetails> userAlreadyExists(UserAlreadyExists uae, WebRequest wr){
		MyErrorDetails err = new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(uae.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StudentNotFound.class)
	ResponseEntity<MyErrorDetails> studentNotFound(StudentNotFound snf, WebRequest wr){
		MyErrorDetails err = new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(snf.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StudentAlreadyExists.class)
	ResponseEntity<MyErrorDetails> studentAlreadyExists(StudentAlreadyExists sae , WebRequest wr){
		MyErrorDetails err = new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(sae.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoRecordFound.class)
	ResponseEntity<MyErrorDetails> noRecordFound(NoRecordFound nrf, WebRequest wr){
		MyErrorDetails err = new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(nrf.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CourseNotFound.class)
	ResponseEntity<MyErrorDetails> courseNotFound(CourseNotFound cnf, WebRequest wr){
		MyErrorDetails err = new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(cnf.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(CourseAlreadyExists.class)
	ResponseEntity<MyErrorDetails> courseAlreadyExists(CourseAlreadyExists cae , WebRequest wr){
		MyErrorDetails err = new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(cae.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	ResponseEntity<MyErrorDetails> noHandlerFound(NoHandlerFoundException nhf, WebRequest wr){
		MyErrorDetails err = new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(nhf.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<MyErrorDetails> exceptionHandler(Exception ie, WebRequest wr){
		MyErrorDetails err = new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
}
