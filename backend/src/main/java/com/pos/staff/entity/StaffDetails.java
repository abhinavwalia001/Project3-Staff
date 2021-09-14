package com.pos.staff.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Staff")
public class StaffDetails {
	
	
	@Id
	@Column(nullable=false,unique=true)
	private String email;
	
	
	@Column(nullable=false,length=8)
	private String password;


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

