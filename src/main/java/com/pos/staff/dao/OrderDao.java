package com.pos.staff.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pos.staff.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer > {
	
	@Query("SELECT count(*) FROM Order o WHERE o.customer.phoneNumber=:customerId")
	Long getCount(@Param("customerId") Long customerId);

	@Query("SELECT o.orderId FROM Order o WHERE o.customer.phoneNumber=:userId AND o.status=:status")
	Integer getOrderId(@Param("userId") Long userId,@Param("status") String status);

	

	
}
