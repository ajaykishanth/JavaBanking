package com.task.bank.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.task.bank.response.dto.CityResponseDTO;
import com.task.bank.service.impl.CityServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/city")
@AllArgsConstructor
public class CityController {

	
	private final CityServiceImpl cityService;
	
	@GetMapping("/state/{id}")
    @Operation(summary="byState  ",
	description="Method to get list of cities by State",
	responses= {
			@ApiResponse(responseCode="200",description="Succesone"),
			@ApiResponse(responseCode="400",description="Bad Operation"),
	}
)
	public ResponseEntity<?> getCities(@Valid @PathVariable("id") Long stateId) {	    
		   List<CityResponseDTO> cities = cityService.getCitiesbyStateId(stateId);
		    return cities.isEmpty()
		    		?ResponseEntity.notFound().build()
		    			:ResponseEntity.ok(cities);
		    		
	}	
	
	
}

