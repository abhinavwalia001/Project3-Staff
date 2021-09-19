package com.pos.staff.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "states")
public class State{
	@Id @SequenceGenerator(name="state_sequence",sequenceName="state_hibernate_sequence",allocationSize=1) @GeneratedValue(generator="state_sequence") @Column(name = "state_id")
	private Long id;
		
	@Column(name = "state_name")
	private String name;
		
	@ManyToOne @JoinColumn(name = "country_id") @JsonIgnore
	private Country country;
		
	@OneToMany(mappedBy="state") @JsonIgnore
	private List<Address> addresses;

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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", country=" + country + ", addresses=" + addresses + "]";
	}
	
	
}



