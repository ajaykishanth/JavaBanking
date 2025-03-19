package com.task.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.bank.entity.Pincode;

@Repository
public interface PincodeRepo extends JpaRepository<Pincode, Long>{

	List<Pincode> findByCityCityName(String cityName);
	
}
