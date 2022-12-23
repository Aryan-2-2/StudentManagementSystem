package com.masai.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Admin;
import com.masai.exception.UserAlreadyExists;
import com.masai.repository.AdminAuthenticationRepository;

@Service
public class AdminAuthenticationServiceImpl implements AdminAuthenticationServiceIntr{

	@Autowired
	AdminAuthenticationRepository adminAuthenticationRepository;
	
	@Override
	public String saveUser(Admin admin) throws UserAlreadyExists{
		 Optional<Admin> f_admin =    adminAuthenticationRepository.findById(admin.getAdminId());
	     if(f_admin.isPresent()){
	    	 throw new UserAlreadyExists("user already exists with this details");
	     }
	     adminAuthenticationRepository.save(admin);
	     return "user is saved successfully";
	}


	
}
