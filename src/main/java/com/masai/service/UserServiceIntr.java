package com.masai.service;

import com.masai.entities.User;
import com.masai.exception.UserAlreadyExists;

public interface UserServiceIntr {

	public String saveUser(User user) throws UserAlreadyExists;
}
