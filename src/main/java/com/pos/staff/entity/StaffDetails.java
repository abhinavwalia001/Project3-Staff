package com.pos.staff.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name="Staff")
public class StaffDetails {

	@Id
	@Column(unique=true)
	private String email;

	@Column(nullable=false)
	@Size(min=8)
	private String password;

}

