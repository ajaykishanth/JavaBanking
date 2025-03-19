package com.task.bank.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.bank.entity.City;

@Repository
public interface CityRepo extends JpaRepository<City, Long>{

	
	Optional<City> findByCityName(String cityName);
	List<City> findByStateStateName(String stateName);
	
}
