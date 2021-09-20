package com.pos.staff.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "addresses")
public class Address {
	    @SequenceGenerator(name="address_sequence",sequenceName="address_hibernate_sequence",allocationSize=1)
		@Id @GeneratedValue(generator="address_sequence") @Column(name="address_id")
		private Long id;
		
		@Column(name = "address_line")
		private String addressLine;
		
		@Column(name = "address_city")
		private String city;
		
		@Column(name = "address_pincode")
		private Long pinCode;
		
		@ManyToOne 
		@JoinColumn(name = "state_id")
		private State state;
		
		@ManyToOne
		@JoinColumn(name = "customer_id") 
		private Customer customer;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAddressLine() {
			return addressLine;
		}

		public void setAddressLine(String addressLine) {
			this.addressLine = addressLine;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public Long getPinCode() {
			return pinCode;
		}

		public void setPinCode(Long pinCode) {
			this.pinCode = pinCode;
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "Address [id=" + id + ", addressLine=" + addressLine + ", city=" + city + ", pinCode=" + pinCode
					+ ", state=" + state + ", customer=" + customer + "]";
		}
		
		
}


