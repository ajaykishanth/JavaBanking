package com.task.bank.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.task.bank.entity.State;

@Repository
public interface StateRepo extends JpaRepository<State, Long>{


		Optional<State> findByStateName(String stateName);
		List<State>	findByCountryCountryName(String countryName);
}
