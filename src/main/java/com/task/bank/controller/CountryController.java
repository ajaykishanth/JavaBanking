package com.task.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.task.bank.request.dto.CountryRequestDTO;
import com.task.bank.response.dto.CountryResponseDTO;
import com.task.bank.service.CountryService;

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
    public ResponseEntity<CountryResponseDTO> createCountry(@RequestBody CountryRequestDTO countryRequestDTO) {
        return ResponseEntity.ok(countryService.createCountry(countryRequestDTO));
        
    }

    // Read
    @GetMapping("/all")
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

