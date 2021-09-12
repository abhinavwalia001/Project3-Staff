package com.pos.staff.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pos.staff.entity.StaffDetails;
import com.pos.staff.exception.DuplicateEmailException;
import com.pos.staff.exception.EmailNotFoundException;
import com.pos.staff.service.StaffService;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StaffController {
	@Autowired(required=true)
	private StaffService staffService;
	
	
	
	@GetMapping("/staff/{email}")
	public ResponseEntity<StaffDetails> getStaffByEmail(@PathVariable String email){
		return new ResponseEntity<>(staffService.getStaffByEmail(email),new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping("/staff")
	public ResponseEntity<String> addStaff(@RequestBody StaffDetails staff){
		
		return new ResponseEntity<>(staffService.addStaff(staff),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping("/staff/{email}")
	public ResponseEntity<String> updateStaff(@PathVariable String email, @RequestBody StaffDetails staff){
		
		return new ResponseEntity<>(staffService.updateStaff(email,staff),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/staff/login")
	public StaffDetails login(@RequestParam("email")String email,@RequestParam("password")String password,HttpServletRequest request) {
		return staffService.login(email, password);	
	}
	
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<String> emailNotFound(EmailNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseEntity<String> duplicateEmailFound(DuplicateEmailException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}


}






