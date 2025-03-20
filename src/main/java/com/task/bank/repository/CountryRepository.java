package com.task.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.bank.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{
	
		
	
	  Optional<Country> findByCountryId(Long countryId);
}
