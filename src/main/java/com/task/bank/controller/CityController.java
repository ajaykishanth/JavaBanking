package com.task.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.task.bank.response.dto.CityResponseDTO;
import com.task.bank.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

	
	private final CityService cityService;
	
	@Autowired
	public CityController(CityService cityService) {
		this.cityService =cityService;
	}
	
	@GetMapping("/by-state")
	public ResponseEntity<?> getCities(@RequestParam String stateName) {
	    if (stateName == null || stateName.isEmpty()) {
	        return ResponseEntity.badRequest().body("Param cannot be empty");
	    }

	    List<CityResponseDTO> cities = cityService.getCitiesbyStateName(stateName);
	    
	    if (cities.isEmpty()) {
	        return ResponseEntity.ok("No data");
	    }
	    
	    return ResponseEntity.ok(cities);
	}	
	
	
}

