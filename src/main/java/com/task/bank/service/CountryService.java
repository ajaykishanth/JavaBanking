package com.task.bank.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.bank.entity.Country;
import com.task.bank.repo.CountryRepo;
import com.task.bank.request.dto.CountryRequestDTO;
import com.task.bank.response.dto.CountryResponseDTO;

@Service
public class CountryService {
	
	
	private CountryRepo countryRepo;
	
	@Autowired
	public CountryService(CountryRepo countryRepo) {
		this.countryRepo =countryRepo;
	}
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CountryResponseDTO createCountry(CountryRequestDTO countryRequestDTO) {
		
		Country country = modelMapper.map(countryRequestDTO, Country.class);		
		Country savedCountry = countryRepo.save(country);
		return modelMapper.map(savedCountry, CountryResponseDTO.class);
		
	}
	
	public List<CountryResponseDTO> getAllCountries(){
		return countryRepo.findAll().stream()
				.map(country -> modelMapper.map(country,CountryResponseDTO.class))
				.collect(Collectors.toList());
	}
	
	   public Optional<CountryResponseDTO> getCountryById(Integer countryId) {
	        return countryRepo.findById(countryId)
	                .map(country->modelMapper.map(country, CountryResponseDTO.class));
	    }
	

}
