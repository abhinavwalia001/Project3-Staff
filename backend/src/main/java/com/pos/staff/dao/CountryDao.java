package com.pos.staff.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.staff.entity.Country;

public interface CountryDao extends JpaRepository<Country,Long>{

}
