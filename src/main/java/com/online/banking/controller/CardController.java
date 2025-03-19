package com.online.banking.controller;

import com.online.banking.request.dto.IssueCardRequestDTO;
import com.online.banking.request.dto.ActivateCardRequestDTO;
import com.online.banking.request.dto.BlockCardRequestDTO;
import com.online.banking.response.dto.IssueCardResponseDTO;
import com.online.banking.response.dto.ActivateCardResponseDTO;
import com.online.banking.response.dto.BlockCardResponseDTO;
import com.online.banking.service.IssueCardService;
import com.online.banking.service.ActivateCardService;
import com.online.banking.service.BlockCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private IssueCardService issueCardService;

    @Autowired
    private ActivateCardService activateCardService;

    @Autowired
    private BlockCardService blockCardService;

    @PostMapping("/issue")
    public IssueCardResponseDTO issueCard(@RequestBody IssueCardRequestDTO request) {
        return issueCardService.issueCard(request);
    }

    @PostMapping("/activate")
    public ActivateCardResponseDTO activateCard(@RequestBody ActivateCardRequestDTO request) {
        return activateCardService.activateCard(request);
    }

    @PostMapping("/block")
    public BlockCardResponseDTO blockCard(@RequestBody BlockCardRequestDTO request) {
        return blockCardService.blockCard(request);
    }
}

