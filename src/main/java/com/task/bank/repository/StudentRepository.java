package com.task.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.bank.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	
	Optional<Student> findByRollno(Integer rollNo);
}
