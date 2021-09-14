package com.pos.staff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String updateStaff(String email, StaffDetails staffUpdated)  {
		
		
		return staffDao.findByEmail(email)
				.map(staff -> {	
				staff.setPassword(staffUpdated.getPassword());
					Optional<StaffDetails> passwordOptional=staffDao.getStaffByPasswordUpdate(staffUpdated.getPassword(),email);
					if(passwordOptional.isPresent()) {
						throw new DuplicateEmailException("error 404");
					}
					
				staffDao.save(staffUpdated);
				return "Staff updated";
				}).orElseThrow(() -> new EmailNotFoundException("error 404"+email)); 
	}

	@Override
	public String addStaff(StaffDetails staff)  {
		Optional<StaffDetails> emailOptional=staffDao.getStaffByEmail(staff.getEmail());
		if(emailOptional.isPresent()) {
			throw new DuplicateEmailException("Staff already exist");
		}
			
		staffDao.save(staff);
		return "Staff added";
	}



	@Override
	public StaffDetails getStaffByEmail(String email)  {
		Optional<StaffDetails> optionalStaff = staffDao.findByEmail(email);
		  if(optionalStaff.isPresent()) {
	    		return optionalStaff.get();
	    	}else {
	    		throw new EmailNotFoundException("email not found "+ email);
	    	}
	  }
	
	@Override
	public StaffDetails login(String email, String password) {
		List<StaffDetails> staffList=staffDao.login(email,password);
		if(staffList.size()>0)
			return staffList.get(0);
		return null;
	

	}

}





