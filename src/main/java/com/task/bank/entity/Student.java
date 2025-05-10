package com.task.bank.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8364708076297773116L;

	@Id
	@Column(name="rollNo")
	private Integer rollno;
	
	@Column(name="Name")
	private String name;

}
