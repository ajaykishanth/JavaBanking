package com.task.bank.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="city")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable{
	

	private static final long serialVersionUID = 441924532915342228L;
	
	
	

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "city_id")
	    private Long cityId;
	    
	    @NotEmpty(message="City Name cannot be Empty")
	    @Column(name = "city_name", nullable = false)
	    private String cityName;

	    @Column(name = "is_active")
	    private Boolean isActive;
	    
	    @ManyToOne
	    @JoinColumn(name = "state_id",nullable =false)
	    private State state;


	    
	    
	    
	    
}
