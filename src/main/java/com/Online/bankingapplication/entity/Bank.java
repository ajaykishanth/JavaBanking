	package com.Online.bankingapplication.entity;
	
	import jakarta.persistence.*;
	
	import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
	
	import com.fasterxml.jackson.annotation.JsonFormat;
	
	@Entity
	@Table(name = "user_table_register")
	@Data
	@NoArgsConstructor  
	public class Bank implements Serializable{
	
		
	    /**
		 * 
		 */
		private static final long serialVersionUID = 911416326658299271L;

		
		

		@Id
	    @Column(unique = true, nullable = false)
	    private String userId;
	
	    @Column(unique = true, nullable = false)
	    private String accountHolderName;
	
	    @Column(nullable = false)
	    private String email;
	
	    @Column(nullable = false)
	    private String phoneNumber;
	
	    @Column(nullable = false)
	    private String address;
	
	    
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	    private String dateOfBirth;
	
	    @Column(nullable = false)
	    private Boolean isActive;
	
	    @Column(nullable = false)
	    private Boolean isDeleted= false;
	    
	    @Column( nullable = false)
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	  private LocalDate registrationDate = LocalDate.now();
	  
	  
	    @Column( nullable = false)
	  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	  private LocalDate lastUpdatedDate = LocalDate.now();
	    
	    @Column( nullable = false)
	    private String password;
	
	   
	    @Column( nullable = false)
	    private Long pincodeId;
	  
	}
	
	
	
	
