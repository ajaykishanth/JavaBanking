package com.task.bank.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.task.bank.repository.CountryRepository;
import com.task.bank.response.dto.CountryResponseDTO;
import com.task.bank.service.CountryService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CountryServiceImpl  implements CountryService{
	
	
	private final CountryRepository countryRepo;
	private final ModelMapper modelMapper;
	
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
