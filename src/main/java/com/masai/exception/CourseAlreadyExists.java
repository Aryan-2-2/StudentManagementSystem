package com.masai.exception;

public class CourseAlreadyExists extends Exception{
	
	public CourseAlreadyExists(){
		
	}
	public CourseAlreadyExists(String message) {
		super(message);
	}

}
