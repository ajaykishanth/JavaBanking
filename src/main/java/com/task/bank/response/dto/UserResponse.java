package com.task.bank.response.dto;


import com.task.bank.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    // Constructor to map entity to DTO
    public UserResponse(User user) {
        this.userId = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
    }
}
