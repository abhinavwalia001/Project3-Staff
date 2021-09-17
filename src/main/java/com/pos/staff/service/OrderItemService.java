package com.pos.staff.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pos.staff.entity.OrderItem;

public interface OrderItemService {
	public ResponseEntity<String> addItems(Integer orderId,Integer productId,OrderItem orderItem);
	public ResponseEntity<List<OrderItem>> getOrderedItems(Integer orderId);
}
