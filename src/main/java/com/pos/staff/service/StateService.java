package com.pos.staff.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pos.staff.entity.State;

public interface StateService {

	public List<State> getStatesByCountry(Long countryId);

	public ResponseEntity<String> addState(Long countryId, State state);
	
}
