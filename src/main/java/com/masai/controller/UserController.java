package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entities.User;
import com.masai.exception.UserAlreadyExists;
import com.masai.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/create")
	ResponseEntity<String> saveUser(@RequestBody User user) throws UserAlreadyExists{
		String message = userService.saveUser(user);
		return new ResponseEntity<>(message,HttpStatus.CREATED);
	}
	
}
