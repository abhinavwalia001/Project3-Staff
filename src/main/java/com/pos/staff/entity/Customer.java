package com.pos.staff.entity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customers")
public class Customer {
		@Id @Column(name="customer_id")
		private Long phoneNumber;
		
		@Column(name="customer_name")
		private String name;
		
		@Column(name="customer_email")
		private String email;
		
		@Column(name="customer_password")
		private String password="1111";
		
		@OneToMany(mappedBy = "customer") 
		private List<Address> addresses;
		
		@OneToMany(mappedBy="customer") @JsonIgnore
		private List<Order> orders;

		public Long getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(Long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

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

		public List<Address> getAddresses() {
			return addresses;
		}

		public void setAddresses(List<Address> addresses) {
			this.addresses = addresses;
		}

		public List<Order> getOrders() {
			return orders;
		}

		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}

		@Override
		public String toString() {
			return "Customer [phoneNumber=" + phoneNumber + ", name=" + name + ", email=" + email + ", addresses="
					+ addresses + ", orders=" + orders + "]";
		}
		
		
		
}


