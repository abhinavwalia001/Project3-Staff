package com.pos.staff.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pos.staff.dao.CountryDao;
import com.pos.staff.entity.Country;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryDao countryDao;

	@Override
	public ResponseEntity<String> addCountry(Country country) {
		// TODO Auto-generated method stub
		countryDao.save(country);
		return new ResponseEntity<String>("Country Details Added Successfully!",new HttpHeaders(),HttpStatus.OK);
	}

	@Override
	public List<Country> getCountryList() {
		List<Country> countryList = new ArrayList<>();
		countryList = countryDao.findAll();
		return countryList;
	}

}
