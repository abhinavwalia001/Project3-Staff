package com.pos.staff.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

	
@Entity
@Table(name = "countries")
public class Country{
		@SequenceGenerator(name="country_sequence",sequenceName="country_hibernate_sequence",allocationSize=1)
		@Id @GeneratedValue(generator="country_sequence") @Column(name = "country_id")
		private Long id;
		
		@Column(name = "country_name", nullable = false)
		private String name;
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


}



