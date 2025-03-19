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
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="city")
public class City implements Serializable{
	
	 private static final long serialVersionUID = 1L; 

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "city_id")
	    private Long cityId;
	    
	    @NotEmpty(message="City Name cannot be Empty")
	    @Column(name = "city_name", nullable = false)
	    private String cityName;

	    @Column(name = "is_active")
	    private Boolean isActive;
	    
	    @ManyToOne
	    @JoinColumn(name = "state_id",nullable =false)
	    private State state;

		public Long getCityId() {
			return cityId;
		}

		public void setCityId(Long cityId) {
			this.cityId = cityId;
		}

		public String getCityName() {
			return cityName;
		}

		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		public Boolean getIsActive() {
			return isActive;
		}

		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}

		public City(Long cityId, String cityName, Boolean isActive, State state) {
			super();
			this.cityId = cityId;
			this.cityName = cityName;
			this.isActive = isActive;
			this.state = state;
		}

		public City() { 
			super();
			 
		}
	    
	    
	    
	    
	    
}
