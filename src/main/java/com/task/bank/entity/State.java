package com.task.bank.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name="state")
public class State implements Serializable{
	
	 private static final long serialVersionUID = 1L; 

	    @Id
	    @Column(name = "state_id")  // Column name in the table
	    private Long stateId;

	    @NotEmpty(message="State Name should not be Empty")
	    @Column(name = "state_name")  // Column name in the table
	    private String stateName;
	    
	    
	    @ManyToOne
	    @JoinColumn(name = "country_id",nullable =false)
	    private Country country;

	    @Column(name = "is_active")  // Column name in the table
	    private Boolean isActive;  // Use Boolean for nullable fields, if the column allows null

	    // Default constructor
	    public State() {
	    }

	    // Getters and Setters
	    public Long getStateId() {
	        return stateId;
	    }

	    public void setStateId(Long stateId) {
	        this.stateId = stateId;
	    }

	    public String getStateName() {
	        return stateName;
	    }

	    public void setStateName(String stateName) {
	        this.stateName = stateName;
	    }

	    public Country getCountry() {
	        return country;
	    }

	    public void setCountry(Country country) {
	        this.country = country;
	    }

	    public Boolean getIsActive() {
	        return isActive;
	    }

	    public void setIsActive(Boolean isActive) {
	        this.isActive = isActive;
	    }

		public State(Long stateId, @NotEmpty(message = "State Name should not be Empty") String stateName,
				Country country, Boolean isActive) {
			super();
			this.stateId = stateId;
			this.stateName = stateName;
			this.country = country;
			this.isActive = isActive;
		}


	    
	    
	    
	
	
}
