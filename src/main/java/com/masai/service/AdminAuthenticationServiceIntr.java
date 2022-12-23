package com.masai.service;

import com.masai.entities.Admin;
import com.masai.exception.UserAlreadyExists;

public interface AdminAuthenticationServiceIntr {

	public String saveUser(Admin admin) throws UserAlreadyExists;
}
