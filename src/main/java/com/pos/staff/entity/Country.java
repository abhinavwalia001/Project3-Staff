package com.pos.staff.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	
@Entity
@Table(name = "countries")
public class Country{
		@Id @GeneratedValue @Column(name = "country_id")
		private Long id;
		
		@Column(name = "country_name", nullable = false)
		private String name;
		
		@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
		private List<State> states;

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

		public List<State> getStates() {
			return states;
		}

		public void setStates(List<State> states) {
			this.states = states;
		}

		@Override
		public String toString() {
			return "Country [id=" + id + ", name=" + name + ", states=" + states + "]";
		}
}



