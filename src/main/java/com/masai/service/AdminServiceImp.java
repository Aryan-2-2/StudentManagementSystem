package com.masai.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.entities.Course;
import com.masai.entities.Student;
import com.masai.exception.CourseAlreadyExists;
import com.masai.exception.CourseNotFound;
import com.masai.exception.NoRecordFound;
import com.masai.exception.StudentAlreadyExists;
import com.masai.exception.StudentNotFound;
import com.masai.repository.CourseRepository;
import com.masai.repository.StudentRepository;

@Service
public class AdminServiceImp implements AdminServiceIntr{

	@Autowired
    private	StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository  courseRepository;
	
	@Override
	public String admitStudent(Student student) throws StudentAlreadyExists {
	     Optional<Student> fetched_student = studentRepository.findById(student.getStudent_Code());
		 if(fetched_student.isPresent()) {
			 throw new StudentAlreadyExists("student already exists with this details");
		 }
		 studentRepository.save(student);
		return "student details saved successfully";
	}

	@Override
	public String uploadCourseDetails(Course course) throws CourseAlreadyExists {
		   Optional<Course> fetched_course =  courseRepository.findByCourseName(course.getCourseName());
	       if(fetched_course.isPresent()) {
            throw new CourseAlreadyExists("Course already exists with this details");
	       }
	       courseRepository.save(course);
	       return "course details saved successfully";
	}

	@Override
	public String assignCourseToStudent(Integer studentCode, String courseName) throws StudentNotFound, CourseNotFound {
	       Optional<Student> fetched_student = studentRepository.findById(studentCode);
	       if(fetched_student.isEmpty()) {
	    	   throw new StudentNotFound("Student not found with this student code : " + studentCode);
	       }
	       Optional<Course> fetched_course = courseRepository.findByCourseName(courseName);
	       if(fetched_course.isEmpty()) {
	    	   throw new CourseNotFound("course not found with this course name : "+ courseName);
	       }
	       fetched_student.get().getCourses().add(fetched_course.get());
	       fetched_course.get().getStudents().add(fetched_student.get());
	       
	       
	       courseRepository.save(fetched_course.get());
	       studentRepository.save(fetched_student.get());
	       
	       
	       
	       return "student with student code " + studentCode + " assigned to course " +courseName+ "successfully " + courseName;
	}

	@Override
	public Student getStudentDetailsByStudentName(String studentName) throws StudentNotFound {
		   Optional<Student> fetched_Student = studentRepository.findByStudentName(studentName);
	       if(fetched_Student.isEmpty()) {
	    	   throw new StudentNotFound("student not found with this name " + studentName);
	       }
	       return fetched_Student.get();
	}

	@Override
	public List<Student> getStudentsByCourseName(String courseName) throws CourseNotFound, NoRecordFound {
		   Optional<Course> fetched_course =  courseRepository.findByCourseName(courseName);
		   if(fetched_course.isEmpty()) {
			   throw new CourseNotFound("course not found with this course name " + courseName );
		   }
		   List<Student> students = fetched_course.get().getStudents();
		   if(students.isEmpty()) {
			  throw new NoRecordFound("no student record found");
		  }
		  return students;
	}

}
