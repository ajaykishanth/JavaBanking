package com.task.bank.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="state")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class State implements Serializable{
	
	 private static final long serialVersionUID = 1L; 

	    @Id
	    @Column(name = "state_id")  // Column name in the table
	    private Long stateId;

	    @NotEmpty(message="State Name should not be Empty")
	    @Column(name = "state_name")  // Column name in the table
	    private String stateName;
	    
	    
	    @ManyToOne
	    @JoinColumn(name = "country_id",nullable =false)
	    private Country country;

	    @Column(name = "is_active")  // Column name in the table
	    private Boolean isActive;  // Use Boolean for nullable fields, if the column allows null

	    
	    
	    
	
	
}
