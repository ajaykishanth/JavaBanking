package com.task.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.bank.entity.Pincode;

@Repository
public interface PincodeRepository extends JpaRepository<Pincode, Long>{

	List<Pincode> findByCityCityId(Long cityId);
	
}
