package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.Admin;
import com.masai.exception.UserAlreadyExists;
import com.masai.service.AdminAuthenticationServiceImpl;

@RestController
@RequestMapping("/create")
public class AdminAuthenticationController {

	@Autowired
	private AdminAuthenticationServiceImpl adminAuthenticationServiceImpl;
	
	@PostAuthorize(value = "ADMIN")
	@PostMapping("/admin")
	ResponseEntity<String> saveAdmin(@Valid @RequestBody Admin admin) throws UserAlreadyExists{
		String message = adminAuthenticationServiceImpl.saveUser(admin);
		return new ResponseEntity<>(message,HttpStatus.CREATED);
	}
	
}
