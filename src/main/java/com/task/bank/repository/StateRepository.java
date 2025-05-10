package com.task.bank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.task.bank.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{


		Optional<State> findByStateId(Long stateId);
		List<State>	findByCountryCountryId(Long countryId);
}
