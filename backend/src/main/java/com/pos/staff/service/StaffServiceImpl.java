package com.pos.staff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.pos.staff.dao.StaffDao;
import com.pos.staff.entity.StaffDetails;
import com.pos.staff.exception.DuplicateEmailException;
import com.pos.staff.exception.EmailNotFoundException;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDao staffDao;
	
	@Override
	public ResponseEntity<String> addStaff(StaffDetails staff)  {
		ResponseEntity<String> response=null;
		staffDao.save(staff);
		response=new ResponseEntity<String>("Staff details added successfully!",new HttpHeaders(),HttpStatus.OK);
		return response;
	}
	@Override
	public ResponseEntity<StaffDetails> getStaff(String email)  {
		StaffDetails staff=staffDao.findById(email).get();
		return new ResponseEntity<>(staff,new HttpHeaders(),HttpStatus.OK);
	  }
	@Override
	public ResponseEntity<String> updateStaff(String email, StaffDetails staffUpdated)  {
		return staffDao.findById(email)
				.map(staff->{
					staff.setPassword(staffUpdated.getPassword());
					staffDao.save(staff);
					return new ResponseEntity<>("Password updated successfully!",new HttpHeaders(),HttpStatus.OK);
				}).orElse(new ResponseEntity<String>("User not found!",new HttpHeaders(),HttpStatus.NOT_FOUND));
	}

	@Override
	public StaffDetails login(String email, String password) {
		List<StaffDetails> staffList=staffDao.login(email,password);
		if(staffList.size()>0)
			return staffList.get(0);
		return null;
	

	}

}





