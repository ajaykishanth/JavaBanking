package com.Online.bankingapplication.entity;

import jakarta.persistence.*;

import lombok.Data;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "user_table")
@Data
public class Bank {

    @Id
    @Column(unique = true, nullable = false)
    private String userId;

    private String accountHolderName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    private String address;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private Boolean isDeleted;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate registrationDate = LocalDate.now();
  
  
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate lastUpdatedDate = LocalDate.now();
    
   
  @PrePersist
  protected void onCreate() {
      if (this.isActive == null) {
          this.isActive = true;
      }
      if (this.isDeleted == null) {
          this.isDeleted = false;
      }
      this.registrationDate = LocalDate.now();
      this.lastUpdatedDate = LocalDate.now();
  }
  
  
}




