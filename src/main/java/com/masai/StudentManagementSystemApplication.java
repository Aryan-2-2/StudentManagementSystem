package com.masai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.masai.entities.Admin;
import com.masai.service.AdminAuthenticationServiceImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class StudentManagementSystemApplication implements CommandLineRunner{

	@Autowired
	AdminAuthenticationServiceImpl adminAuthenticationServiceImpl;
	
	@Autowired
	private BCryptPasswordEncoder  bcryptPassword ;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		Admin admin = new Admin(1, "aryan", "9038473989", this.bcryptPassword.encode("aA@123456789"), "ADMIN");
    	adminAuthenticationServiceImpl.saveUser(admin);
	}

}
