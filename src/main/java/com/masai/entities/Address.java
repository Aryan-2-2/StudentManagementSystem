package com.masai.entities;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@javax.persistence.Entity
public class Address { 
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Integer addressId;

	@javax.validation.constraints.NotNull(message = " Area should not be null")
	private String area;
	
	@NotNull(message = "State Name should not be null")
	private String state;
	
	@NotNull(message = "District should not be null")
	private String district;
	
	@NotNull(message = "Pincode should not be null")
	private Integer pincode;
	
	@NotNull(message = "Address Type should not be null")
	private String addressType;
}
