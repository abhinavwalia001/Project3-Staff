package com.pos.staff.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.staff.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long > {
	

}
