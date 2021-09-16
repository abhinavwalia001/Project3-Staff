package com.pos.staff.service;

import org.springframework.http.ResponseEntity;

import com.pos.staff.entity.StaffDetails;

public interface StaffService {

	public ResponseEntity<String> updateStaff(String email, StaffDetails staff);

	public ResponseEntity<String> addStaff(StaffDetails staff);

	public ResponseEntity<StaffDetails> getStaff(String email);

	public StaffDetails login(String email, String password);

}
