package com.masai.entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Course {
	@Id
	@NotNull(message = " Course Name should not be null")
	private String courseName;
	
	@NotNull(message = " Description should not be null")
	private String description;
	
	@NotNull(message = " Area should not be null")
	private String courseType;
	
	@NotNull(message = " Duration should not be null")
	private String duration;
	
	@NotNull(message = " Topics should not be null")
	private String topics;
	
	@ManyToMany(mappedBy = "courses" , cascade = CascadeType.ALL)
	@JsonIgnore
	List<Student> students;
}
