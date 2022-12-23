package com.masai.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Admin implements UserDetails{
	@Id
	private Integer adminId;
	
	@NotNull(message = "User Name should not be null")
	private String name;
	
	@NotNull(message = "mobile number should not be null")
	private String mobileNumber;
	
	@NotNull(message = "password should not be null")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$", message = "Password formate is wrong")
	private String password;
	
	
	
	@NotNull(message = "role should not be null")
	private String role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		java.util.List<GrantedAuthority> list=new ArrayList<>();
	    list.add(new SimpleGrantedAuthority(this.role));
	    return list;

	}

	@Override
	public String getUsername() {
		return this.mobileNumber;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
}
