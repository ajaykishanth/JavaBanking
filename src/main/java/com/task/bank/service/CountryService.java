package com.task.bank.service;

import java.util.List;
import java.util.Optional;
import com.task.bank.response.dto.CountryResponseDTO;

public interface CountryService {
	
		
	public List<CountryResponseDTO> getAllCountries();
	public Optional<CountryResponseDTO> getCountryById(Integer countryId);
	

}
