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
	@Autowired
	private StaffService staffService;
	
	@PostMapping("/add-staff")
	public ResponseEntity<String> addStaff(@RequestBody StaffDetails staff){
		if(staff.getPassword().length()<8)
		{
			return new ResponseEntity<String>("Password must contain atleast 8 characters!",new HttpHeaders(),HttpStatus.OK);
		}
		return staffService.addStaff(staff);
	}
	
	@GetMapping("/get-staff/{email}")
	public ResponseEntity<StaffDetails> getStaff(@PathVariable String email){
		return staffService.getStaff(email);
	}

	@PutMapping("/update-staff/{email}")
	public ResponseEntity<String> updateStaff(@PathVariable String email, @RequestBody StaffDetails staff){
		return staffService.updateStaff(email, staff);
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






