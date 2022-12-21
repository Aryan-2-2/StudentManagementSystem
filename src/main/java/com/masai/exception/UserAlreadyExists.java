package com.masai.exception;

public class UserAlreadyExists extends Exception{

	public UserAlreadyExists() {
		
	}
	public UserAlreadyExists(String messgae) {
		super(messgae);
	}
}
