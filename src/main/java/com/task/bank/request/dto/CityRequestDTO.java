package com.task.bank.request.dto;
import jakarta.validation.constraints.NotEmpty;

	public class CityRequestDTO {

	    @NotEmpty(message = "City Name cannot be Empty")
	    private String cityName;

	    private Boolean isActive;

	    private Integer stateId;
	    

	    // Constructor
	    public CityRequestDTO(String cityName, Boolean isActive, Integer stateId) {
	        this.cityName = cityName;
	        this.isActive = isActive;
	        this.stateId = stateId;
	    }

	    public CityRequestDTO() {
	        super();
	    }

	    // Getters and Setters
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

	    public Integer getStateId() {
	        return stateId;
	    }

	    public void setStateId(Integer stateId) {
	        this.stateId = stateId;
	    }



	    
	    
	    
	    
	    
	    
	}

