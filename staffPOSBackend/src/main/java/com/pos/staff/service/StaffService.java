package com.pos.staff.service;

import com.pos.staff.entity.StaffDetails;


public interface StaffService {

	

	public String updateStaff(String email, StaffDetails staff) ;

	public String addStaff(StaffDetails staff) ;

	public StaffDetails getStaffByEmail(String email) ;

	public StaffDetails login(String email, String password);

	

}


