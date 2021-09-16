package com.pos.staff.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.staff.entity.OrderItem;

public interface OrderItemDao extends JpaRepository<OrderItem,Integer>{
	
}
