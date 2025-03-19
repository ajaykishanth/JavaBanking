package com.task.bank.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pincode")
public class Pincode implements Serializable{
	
	 private static final long serialVersionUID = 1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pincode_id")
    private Long pincodeId;

    @Column(name = "pincode", nullable = false)
    private String pincode;

    @Column(name = "is_active")
    private Boolean isActive;

    // Many-to-one relationship: A pincode is associated with one city
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

	public Long getPincodeId() {
		return pincodeId;
	}

	public void setPincodeId(Long pincodeId) {
		this.pincodeId = pincodeId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Pincode(Long pincodeId, String pincode, Boolean isActive, City city) {
		super();
		this.pincodeId = pincodeId;
		this.pincode = pincode;
		this.isActive = isActive;
		this.city = city;
	}

	public Pincode() {
		super();
	}
    
	
	
    
	

}
