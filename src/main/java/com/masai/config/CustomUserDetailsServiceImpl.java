package com.masai.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.entities.Admin;
import com.masai.repository.AdminAuthenticationRepository;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AdminAuthenticationRepository adminAuthenticationRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 Optional<Admin> fetched_admin =   adminAuthenticationRepository.findByMobileNumber(username);
		 if(fetched_admin.isEmpty()) {
			 throw new UsernameNotFoundException("Invalid Credintial");
		 }
		 
		 return fetched_admin.get();
		
	}

}
