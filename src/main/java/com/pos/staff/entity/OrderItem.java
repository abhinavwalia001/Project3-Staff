package com.pos.staff.entity;	

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="orderItem")
public class OrderItem {
	@SequenceGenerator(name="order_item_sequence",sequenceName="order_item_hibernate_sequence",allocationSize=1)
	@Id @GeneratedValue(generator="order_item_sequence") @Column(name="order_item_id")
	private Integer id;
		
	@Column(name="order_item_quantity")
	private Integer quantity;
		
	@Column(name="order_item_price")
	private Double price;
		
	@ManyToOne @JoinColumn(name="order_id") @JsonIgnore
	private Order order;
		
	@ManyToOne @JoinColumn(name="product_id")
	private Product product;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", quantity=" + quantity + ", price=" + price + ", order=" + order + ", product="
				+ product + "]";
	}
	
	
}



