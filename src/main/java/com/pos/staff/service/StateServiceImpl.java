package com.pos.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pos.staff.dao.CountryDao;
import com.pos.staff.dao.StateDao;
import com.pos.staff.entity.Country;
import com.pos.staff.entity.State;

@Service
public class StateServiceImpl implements StateService{

	@Autowired
	private StateDao stateDao;
	
	@Autowired
	private CountryDao countryDao;

	@Override
	public List<State> getStatesByCountry(Long countryId) {
		
		List<State> stateList = stateDao.getByCountryId(countryId);	
		return stateList;
		
	}

	@Override
	public ResponseEntity<String> addState(Long countryId, State state) {
		return countryDao.findById(countryId)
				.map(country->{
					state.setCountry(country);
					stateDao.save(state);
					return new ResponseEntity<String>("State Details Added Successfully!",new HttpHeaders(),HttpStatus.OK);
				}).orElse(new ResponseEntity<String>("Country Not Found",new HttpHeaders(),HttpStatus.OK)); 

	}
	
}
