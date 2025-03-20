package com.task.bank.request.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchUserRequest {
    private String query;
    private int pageNum = 0;
    private int pageSize = 10;
}
