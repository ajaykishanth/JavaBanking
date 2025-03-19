package com.task.bank.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.bank.entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer>{
	
		
	
	  Optional<Country> findByCountryName(String countryName);
}
