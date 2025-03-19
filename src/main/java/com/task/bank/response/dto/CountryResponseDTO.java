package com.task.bank.response.dto;



//import lombok.Getter;
//import lombok.Setter;

public class CountryResponseDTO {




	private Integer countryId;
	 private String countryName;
	 private String countryCode;
	 private boolean isActive;
	 
	 
	 

	 public Integer getCountryId() {
		return countryId;
	}



	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}



	public String getCountryName() {
		return countryName;
	}



	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}



	public String getCountryCode() {
		return countryCode;
	}



	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}



	public boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}


	    // Constructor
	    public CountryResponseDTO(Integer countryId, String countryName, String countryCode, boolean isActive) {
	        this.countryId = countryId;
	        this.countryName = countryName;
	        this.countryCode = countryCode;
	        this.isActive = isActive;
	    }



		public CountryResponseDTO() {
			super();
		}
	    
	    
	    
	
	    
	    
	
	
}
