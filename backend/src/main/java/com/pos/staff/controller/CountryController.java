package com.pos.staff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.staff.entity.Country;
import com.pos.staff.service.AddressService;
import com.pos.staff.service.CountryService;


@RestController
@RequestMapping("/api/country")
@CrossOrigin("http://localhost:4200")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@PostMapping("/country")
	public ResponseEntity<String> addCountry(@RequestBody Country country)
	{
		return countryService.addCountry(country);
	}
	
	@GetMapping("/country/countryList")
	public ResponseEntity<List<Country>> getCountryList() 
	{
		List<Country> countryList = countryService.getCountryList();
		return new ResponseEntity<List<Country>>(countryList,new HttpHeaders(),HttpStatus.OK);
	}

}
