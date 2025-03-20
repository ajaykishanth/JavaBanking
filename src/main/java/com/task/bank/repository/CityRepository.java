package com.task.bank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.bank.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	
	Optional<City> findByCityId(Long cityId);
	List<City> findByStateStateId(Long stateId);
	
}
