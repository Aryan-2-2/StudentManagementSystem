package com.masai.entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Student {
    @Id
	@NotNull(message = "Student Code should not be null")
	private Integer student_Code;
    
	@NotNull(message = "Student Name should not be null")
	private String studentName;
	
	@Email(message = "Email format is wrong")
	@NotNull(message = "Name should not be null")
	private String email;
	
	@NotNull(message = "Date Of Birth should not be null")
	private String dateOfBirth;
	
	@NotNull(message = "Gender Details should not be null")
	private String gender;
	
	@NotNull(message = "Mobile Number should not be null")
	@Pattern(regexp = "[0-9]{10}", message = "Mobile No is Invalid")
	private String mobileNumber;
	
	@NotNull(message = "Mother's Name should not be null")
	private String mothersName;
	
	@NotNull(message = "Father's Name should not be null")
	private String fathersName;
	
	@OneToMany
	private  java.util.List<Address> address;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Course> courses;
	
}
