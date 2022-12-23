package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Admin;
import com.masai.exception.UserAlreadyExists;
import com.masai.service.AdminAuthenticationServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminAuthenticationController {

	@Autowired
	private AdminAuthenticationServiceImpl adminAuthenticationServiceImpl;
	
	@PostMapping("/create")
	ResponseEntity<String> saveAdmin(@RequestBody Admin admin) throws UserAlreadyExists{
		String message = adminAuthenticationServiceImpl.saveUser(admin);
		return new ResponseEntity<>(message,HttpStatus.CREATED);
	}
	
}
