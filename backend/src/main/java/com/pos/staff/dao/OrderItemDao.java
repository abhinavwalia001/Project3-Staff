package com.pos.staff.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pos.staff.entity.OrderItem;

public interface OrderItemDao extends JpaRepository<OrderItem,Integer>{
	
	@Query("SELECT sum(o.price) FROM OrderItem o WHERE o.order.orderId=:orderId")
	Double getSumByOrderId(@Param("orderId") Integer orderId);
	
	@Query("FROM OrderItem o WHERE o.order.orderId=:orderId")
	List<OrderItem> getOrderedItems(@Param("orderId") Integer orderId);
	
}
