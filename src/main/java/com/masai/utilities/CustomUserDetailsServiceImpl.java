package com.masai.utilities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.entities.User;
import com.masai.repository.UserRepository;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 
		      User user =   userRepository.findByMobileNumber(username);
	          if(user==null) {
	        	  throw new UsernameNotFoundException("Invalid credintials");
	          }
	          return new CustomUserDetailsImpl(user);
	}

}
