package com.task.bank.response.dto;

public class PincodeResponseDTO {


    private Long pincodeId;
    private String pincode;
    private Boolean isActive;
    private Long cityId;

    // Constructor
    public PincodeResponseDTO(Long pincodeId, String pincode, Boolean isActive, Long cityId) {
        this.pincodeId = pincodeId;
        this.pincode = pincode;
        this.isActive = isActive;
        this.cityId = cityId;
    }

    public PincodeResponseDTO() {
        super();
    }

    // Getters and Setters
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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
	
}
