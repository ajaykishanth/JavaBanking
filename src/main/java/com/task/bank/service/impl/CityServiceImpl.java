package com.task.bank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.task.bank.entity.State;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.task.bank.entity.City;
import com.task.bank.repository.CityRepository;
import com.task.bank.repository.StateRepository;
import com.task.bank.response.dto.CityResponseDTO;
import com.task.bank.service.CityService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
	
	private final CityRepository cityRepo;
	private final StateRepository stateRepo;
    private final ModelMapper modelMapper; 
	

    @Override
	public List<CityResponseDTO> getCitiesbyStateId(Long stateId){
    	
    		Optional<State> state = stateRepo.findById(stateId); 
    		if(state.isEmpty()) {
    			return new ArrayList<CityResponseDTO>();
    		}
		List<City> cities = cityRepo.findByStateStateId(stateId);		
		 return cities.stream()
		            .map(city -> modelMapper.map(city, CityResponseDTO.class))
		            .collect(Collectors.toList());
	}



	
	

}
