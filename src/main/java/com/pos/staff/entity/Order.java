package com.pos.staff.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@SequenceGenerator(name="order_sequence",sequenceName="order_hibernate_sequence",allocationSize=1)
	@GeneratedValue(generator="order_sequence")
	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "order_date")
	private LocalDate date = LocalDate.now();

	@Column(name = "order_total_price",columnDefinition ="double default 0.0")
	private Double totalPrice;

	@Column(name = "order_discount",columnDefinition = "float default 0.0")
	private Float discount;

	@Column(name = "order_payment_mode")
	private String modeOfPayment;

	@Column(name = "order_status",columnDefinition = "varchar(20) default 'Pending'")
	private String status;

	@Column(name = "order_tracking")
	private String tracking;

	@ManyToOne()
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(mappedBy = "order",fetch=FetchType.EAGER)
	private List<OrderItem> orderItems;
}
