package com.masai.repository;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>{

	//@Query(value = "select c from Course c where c.courseName = : n")
	public Optional<Course> findByCourseName(@PathParam("n") String courseName);
	
}