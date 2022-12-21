package com.masai.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    public Optional<Student> findByStudentName(String studentName);
    public Optional<Student> findByDateOfBirth(String dateOfBirth);
}
