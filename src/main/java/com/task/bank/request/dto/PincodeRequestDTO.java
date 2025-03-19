package com.task.bank.request.dto;

import jakarta.validation.constraints.NotEmpty;

public class PincodeRequestDTO {

	

    @NotEmpty(message = "Pincode cannot be Empty")
    private String pincode;

    private Boolean isActive;

    private Long cityId;

    // Constructor
    public PincodeRequestDTO(String pincode, Boolean isActive, Long cityId) {
        this.pincode = pincode;
        this.isActive = isActive;
        this.cityId = cityId;
    }

    public PincodeRequestDTO() {
        super();
    }

    // Getters and Setters
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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
