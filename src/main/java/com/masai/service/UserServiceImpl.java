package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.User;
import com.masai.exception.UserAlreadyExists;
import com.masai.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceIntr{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public String saveUser(User user) throws UserAlreadyExists{
		 Optional<User> f_user =     userRepository.findById(user.getId());
	     if(f_user.isPresent()){
	    	 throw new UserAlreadyExists("user already exists with this details");
	     }
	     userRepository.save(user);
	     return "user is saved successfully";
	}

	
}
