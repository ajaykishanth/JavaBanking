package com.task.bank.entity;



import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table(name="country")
public class Country implements Serializable{
	
	
	 private static final long serialVersionUID = 1L; 
	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="country_id")
	private Integer countryId;
	
//	@NotEmpty(message="Country Name should not be Empty")
	@Column(name ="country_name")
	private String countryName;
	
	
	@NotEmpty(message="Country code should not be Empty")
	 @Column(name = "country_code")
	 private String countryCode;
	
	 @Column(name = "is_active")
	 private boolean isActive;
//	 
//	  @OneToMany(mappedBy = "country")
//	    private List<State> states;
//
//	public List<State> getStates() {
//		return states;
//	}
//
//	public void setStates(List<State> states) {
//		this.states = states;
//	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Country(Integer countryId, String countryName, String countryCode, boolean isActive) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.isActive = isActive;
	}

	public Country() {
		super();
	}
	 
	 
	
	
	

}
