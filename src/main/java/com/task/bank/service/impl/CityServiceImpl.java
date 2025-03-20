package com.task.bank.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.task.bank.entity.City;
import com.task.bank.repository.CityRepository;
import com.task.bank.response.dto.CityResponseDTO;
import com.task.bank.service.CityService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
	
	private final CityRepository cityRepo;
    private final ModelMapper modelMapper; 
	

    @Override
	public List<CityResponseDTO> getCitiesbyStateId(Long stateId){
		
		List<City> cities = cityRepo.findByStateStateId(stateId);
		
		return cities.stream().map(city -> modelMapper.map(city, CityResponseDTO.class))
				.collect(Collectors.toList());
	}



	
	

}
