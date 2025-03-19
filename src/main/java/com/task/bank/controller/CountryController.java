package com.task.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.task.bank.request.dto.CountryRequestDTO;
import com.task.bank.response.dto.CountryResponseDTO;
import com.task.bank.service.CountryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {

    
    private CountryService countryService;
    
    @Autowired
    public CountryController(CountryService countryService) {
    	this.countryService=countryService;
    	
    }

    // Create
    @PostMapping("/country")
    @Operation(summary="Post Method ",
    			description="Post Method to create any country",
    			responses= {
    					@ApiResponse(responseCode="200",description="Succesone"),
    					@ApiResponse(responseCode="400",description="Bad Operation"),
    			}
    )
    public ResponseEntity<CountryResponseDTO> createCountry(@RequestBody CountryRequestDTO countryRequestDTO) {
        return ResponseEntity.ok(countryService.createCountry(countryRequestDTO));
        
    }

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
        if(country.isEmpty())
        	{
        	return ResponseEntity.notFound().build();
        	}else{
        		return ResponseEntity.ok(country);
        	}     
    }

    @GetMapping("/{id}")
    public Optional<CountryResponseDTO> getCountryById(@PathVariable Integer id) {
        return countryService.getCountryById(id);
    }
}

