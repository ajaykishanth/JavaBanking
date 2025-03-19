package com.task.bank.request.dto;

import jakarta.validation.constraints.NotEmpty;

public class StateRequestDTO {

    @NotEmpty(message = "State Name should not be Empty")
    private String stateName;

    private Integer countryId;

    private Boolean isActive;

    // Constructor
    public StateRequestDTO(String stateName, Integer countryId, Boolean isActive) {
        this.stateName = stateName;
        this.countryId = countryId;
        this.isActive = isActive;
    }

    public StateRequestDTO() {
        super();
    }

    // Getters and Setters
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
