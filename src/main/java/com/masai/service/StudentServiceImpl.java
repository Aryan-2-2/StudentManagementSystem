package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Course;
import com.masai.entities.Student;
import com.masai.exception.CourseNotFound;
import com.masai.exception.NoRecordFound;
import com.masai.exception.StudentNotFound;
import com.masai.repository.CourseRepository;
import com.masai.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServiceIntr{

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public Student updateStudentProfile(Student student) throws StudentNotFound {
		  Optional<Student> fetched_student =  studentRepository.findById(student.getStudent_Code());
	      if(fetched_student.isEmpty()) {
	    	  throw new StudentNotFound("student not found");
	      }
	      studentRepository.save(student);
	      return fetched_student.get();
	}

	@Override
	public List<Course> getAssignedCourseByStudentName(String studentName) throws StudentNotFound {
		  
		    
		 Optional<Student> students =  studentRepository.findByStudentName(studentName);
	     if(students.isEmpty()) {
	    	 throw new StudentNotFound("student not found with this name : " + studentName);
	     }
		 return students.get().getCourses();
	}

	@Override
	public List<Course> getAllCourse() throws NoRecordFound {
		 
		List<Course> courses = courseRepository.findAll();
		if(courses.isEmpty()) {
			throw new NoRecordFound("no student record");
		}
		return courses;
		
	}

	@Override
	public String leaveTheCourse(String studentName, String courseName) throws StudentNotFound, CourseNotFound {
		
		 Optional<Student> fetched_student = studentRepository.findByStudentName(studentName);
		 if(fetched_student.isEmpty()) {
			 throw new StudentNotFound("student not found with this name : " + studentName);
		 }
		 Optional<Course> fetched_course = courseRepository.findByCourseName(courseName);
		 if(fetched_course.isEmpty()) {
			 throw new CourseNotFound("course not found with this name : "+courseName );
		 }
		 
		  fetched_course.get().getStudents().remove(fetched_student);
		  fetched_student.get().getCourses().remove(fetched_course);
		  
		  
		  studentRepository.save(fetched_student.get());
		  courseRepository.save(fetched_course.get());
		  
		  
		  return "student leaves the successfully";
	}

}
