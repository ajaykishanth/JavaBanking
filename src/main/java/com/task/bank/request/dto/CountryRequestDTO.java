package com.task.bank.request.dto;



public class CountryRequestDTO {

	private String countryCode;
	private String countryName;
	private boolean isActive;
	
	
	
	 public String getCountryCode() {
		return countryCode;
	}



	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}



	public String getCountryName() {
		return countryName;
	}



	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}



	public Boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}



	public CountryRequestDTO(String countryName, String countryCode, boolean isActive) {
	        this.countryName = countryName;
	        this.countryCode = countryCode;
	        this.isActive = isActive;
	    }



	public CountryRequestDTO() {
		super();
	}




	
	 
}
