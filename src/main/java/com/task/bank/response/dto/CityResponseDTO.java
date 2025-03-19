package com.task.bank.response.dto;




public class CityResponseDTO {


    private Long cityId;
    private String cityName;
    private boolean isActive;
    private Integer stateId;
    private String stateName;

    // Constructor
    public CityResponseDTO(Long cityId, String cityName, Boolean isActive, Integer stateId , String stateName) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.isActive = isActive;
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public CityResponseDTO() {
        super();
    }

    // Getters and Setters
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

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
    
	
}
