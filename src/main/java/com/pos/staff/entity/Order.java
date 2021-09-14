package com.pos.staff.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
	import java.time.LocalDate;
	import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;

	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;

	@Entity
	@Table(name="orders")
	
	public class Order {
		public Integer getOrderId() {
			return orderId;
		}

		public void setOrderId(Integer orderId) {
			this.orderId = orderId;
		}

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		public Double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(Double totalPrice) {
			this.totalPrice = totalPrice;
		}

		public Float getDiscount() {
			return discount;
		}

		public void setDiscount(Float discount) {
			this.discount = discount;
		}

		public String getModeOfPayment() {
			return modeOfPayment;
		}

		public void setModeOfPayment(String modeOfPayment) {
			this.modeOfPayment = modeOfPayment;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getTracking() {
			return tracking;
		}

		public void setTracking(String tracking) {
			this.tracking = tracking;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public List<OrderItem> getOrderItems() {
			return orderItems;
		}

		public void setOrderItems(List<OrderItem> orderItems) {
			this.orderItems = orderItems;
		}

		@Id @GeneratedValue @Column(name="order_id")
		private Integer orderId;
		
		@Column(name="order_date")
		private LocalDate date=LocalDate.now();
		
		@Override
		public String toString() {
			return "Order [orderId=" + orderId + ", date=" + date + ", totalPrice=" + totalPrice + ", discount="
					+ discount + ", modeOfPayment=" + modeOfPayment + ", status=" + status + ", tracking=" + tracking
					+ ", address=" + address + ", customer=" + customer + ", orderItems=" + orderItems + "]";
		}

		@Column(name="order_total_price")
		private Double totalPrice;
		
		@Column(name="order_discount")
		private Float discount;
		
		@Column(name="order_payment_mode")
		private String modeOfPayment;
		
		@Column(name="order_status")
		private String status;
		
		@Column(name="order_tracking")
		private String tracking;
		
		@ManyToOne(cascade=CascadeType.ALL) @JoinColumn(name="customer_id")
		private Customer customer;
		
		@ManyToOne(cascade=CascadeType.ALL) @JoinColumn(name="address_id")
		private Address address;
		
		@OneToMany(mappedBy="order")
		private List<OrderItem> orderItems;
	}



