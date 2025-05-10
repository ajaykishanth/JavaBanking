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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="pincode")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pincode implements Serializable{
	
	
	private static final long serialVersionUID = -7873875523073986130L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pincode_id")
    private Long pincodeId;

    @Column(name = "pincode", nullable = false)
    private String pincode;

    @Column(name = "is_active")
    private Boolean isActive;

    // Many-to-one relationship: A pincode is associated with one city
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
	
    
	

}
