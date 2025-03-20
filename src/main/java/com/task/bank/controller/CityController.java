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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/city")
public class CityController {

	
	private final CityService cityService;
	
	@Autowired
	public CityController(CityService cityService) {
		this.cityService =cityService;
	}
	
	
	
	
	@GetMapping("/by-state")
    @Operation(summary="byState  ",
	description="Method to get list of cities by State",
	responses= {
			@ApiResponse(responseCode="200",description="Succesone"),
			@ApiResponse(responseCode="400",description="Bad Operation"),
	}
)
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

