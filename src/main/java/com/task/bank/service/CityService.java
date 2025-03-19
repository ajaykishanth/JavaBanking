package com.task.bank.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.bank.entity.City;
import com.task.bank.repo.CityRepo;
import com.task.bank.response.dto.CityResponseDTO;

@Service
public class CityService {
	
	private final CityRepo cityRepo;

    @Autowired
    private ModelMapper modelMapper; 
	
	@Autowired
	public CityService(CityRepo cityRepo) {
		this.cityRepo = cityRepo;
	}
	
	public List<CityResponseDTO> getCitiesbyStateName(String stateName){
		
		List<City> cities = cityRepo.findByStateStateName(stateName);
		
		return cities.stream().map(city -> modelMapper.map(city, CityResponseDTO.class))
				.collect(Collectors.toList());
	}
	
	

}
