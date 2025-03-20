package com.task.bank.entity;



import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="country")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country implements Serializable{
	
	
	 private static final long serialVersionUID = 1L; 
	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="country_id")
	private Integer countryId;
	
	@NotEmpty(message="Country Name should not be Empty")
	@Column(name ="country_name")
	private String countryName;
	
	
	@NotEmpty(message="Country code should not be Empty")
	 @Column(name = "country_code")
	 private String countryCode;
	
	 @Column(name = "is_active")
	 private boolean isActive;	 
	
	
	

}
