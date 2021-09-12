package com.pos.staff.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pos.staff.entity.StaffDetails;

@Repository

public interface StaffDao extends JpaRepository<StaffDetails,String> {

	
	@Query("From StaffDetails where email = :email")
	 Optional<StaffDetails> findByEmail(@Param("email") String email);

	@Query("From StaffDetails where email=:email and password=:password")
	Optional<StaffDetails> getStaffByPasswordUpdate(@Param("password")String password, @Param("email")String email);

	@Query("From StaffDetails where email=:email ")
	Optional<StaffDetails> getStaffByEmail(@Param("email")String email);

	@Query("FROM StaffDetails WHERE email=:email AND password=:password")
	List<StaffDetails> login(String email, String password);

	

}
