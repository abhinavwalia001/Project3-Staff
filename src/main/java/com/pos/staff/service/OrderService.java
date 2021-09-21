package com.pos.staff.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pos.staff.dto.OrderListDto;
import com.pos.staff.entity.Order;

public interface OrderService {

	public String deleteOrder(Integer orderId);

	public String updateOrder(Integer orderId, Order orderUpdated);

	public ResponseEntity<String> addOrder(Long customerId, Long addressId, Order order);

	public Order getOrderById(Integer id);

	public List<Order> getAllOrder();

	public Integer getOrderId(Long userId);

	ResponseEntity<OrderListDto> getOrders(Long customerId);
}
