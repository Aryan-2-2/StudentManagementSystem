package com.masai.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Admin;

@Repository
public interface AdminAuthenticationRepository extends JpaRepository<Admin, Integer>{

	
	public Optional<Admin> findByMobileNumber(String mobileNumber);
}
