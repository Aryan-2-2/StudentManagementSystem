package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Admin;
import com.masai.entities.Student;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
