package com.masai.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	
	public User findByMobileNumber(String mobileNumber);
}
