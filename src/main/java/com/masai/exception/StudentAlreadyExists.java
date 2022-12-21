package com.masai.exception;

public class StudentAlreadyExists extends Exception{
	public StudentAlreadyExists(){
		
	}
	public StudentAlreadyExists(String message) {
		super(message);
	}
}
