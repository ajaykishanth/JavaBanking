package com.task.bank.response.dto;

public class StateResponseDTO {

	
	private Long stateId;
    private String stateName;
    private Integer countryId;
    private Boolean isActive;

    // Constructor
    public StateResponseDTO(Long stateId, String stateName, Integer countryId, Boolean isActive) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.countryId = countryId;
        this.isActive = isActive;
    }

    public StateResponseDTO() {
        super();
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

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
	
}
