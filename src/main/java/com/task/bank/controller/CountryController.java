package com.task.bank.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.task.bank.exceptions.ResourceNotFoundException;
import com.task.bank.response.dto.CountryResponseDTO;
import com.task.bank.service.impl.CountryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/country")
@AllArgsConstructor
public class CountryController {

    
    private final CountryServiceImpl countryService;




    // Read
    @GetMapping("/all")
    @Operation(summary="Get Method ",
	description="Get Method to display all Countries",
	responses= {
			@ApiResponse(responseCode="200",description="Succesone"),
			@ApiResponse(responseCode="400",description="Bad Operation"),
	}
)
    public ResponseEntity<List<CountryResponseDTO>> getAllCountries() {
        List<CountryResponseDTO> country =countryService.getAllCountries();
        return ResponseEntity.ok(country);
  
    }
    
    //Get ById
    @GetMapping("/{id}")
    @Operation(summary="Get Method ",
	description="Get Method to display single country by ID",
	responses= {
			@ApiResponse(responseCode="200",description="Succesone"),
			@ApiResponse(responseCode="400",description="Bad Operation"),
	}
    )
    public ResponseEntity<CountryResponseDTO> getCountryById(@Valid @PathVariable Integer id) {
    	Optional<CountryResponseDTO> country =countryService.getCountryById(id);
    	return  country.map(ResponseEntity::ok).orElseThrow(()->new ResourceNotFoundException("Dont have any country in this ID"));
    	
    }
    
    
    
    
}

