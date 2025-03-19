package com.online.banking.service;

import com.online.banking.request.dto.IssueCardRequestDTO;
import com.online.banking.response.dto.IssueCardResponseDTO;

public interface IssueCardService {
    IssueCardResponseDTO issueCard(IssueCardRequestDTO request);
}
