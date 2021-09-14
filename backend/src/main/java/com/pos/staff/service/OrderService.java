package com.pos.staff.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pos.staff.entity.Order;
public interface OrderService {

	public String deleteOrder(Long orderId);

	public String updateOrder(Long orderId, Order orderUpdated);

	public ResponseEntity<String> addOrder(Order order);

	public Order getOrderById(Long id);

	public List<Order> getAllOrder();
}
