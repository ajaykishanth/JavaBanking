package com.online.banking.controller;

import com.online.banking.request.dto.ActivateCardRequestDTO;
import com.online.banking.response.dto.IssueCardResponseDTO;
import com.online.banking.response.dto.ActivateCardResponseDTO;
import com.online.banking.response.dto.BlockCardResponseDTO;
import com.online.banking.service.IssueCardService;
import com.online.banking.service.ActivateCardService;
import com.online.banking.service.BlockCardService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/cards")
@Tag(name = "Card Management", description = "APIs for issuing, activating, and blocking cards")
public class CardController {

    private final IssueCardService issueCardService;
    private final ActivateCardService activateCardService;
    private final BlockCardService blockCardService;

    public CardController(IssueCardService issueCardService, ActivateCardService activateCardService,
                          BlockCardService blockCardService) {
        this.issueCardService = issueCardService;
        this.activateCardService = activateCardService;
        this.blockCardService = blockCardService;
    }

    @PostMapping("/issue/{accountId}")
    @Operation(summary = "Issue a new card", description = "Generates a new card for a given account ID")
    public ResponseEntity<IssueCardResponseDTO> issueCard(@PathVariable("accountId") Long accountId) {
        IssueCardResponseDTO response = issueCardService.issueCard(accountId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/activate")
    public ResponseEntity<ActivateCardResponseDTO> activateCard(@Valid @RequestBody ActivateCardRequestDTO request) {
        ActivateCardResponseDTO response = activateCardService.activateCard(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/block/{cardId}")
    @Operation(summary = "Block a card", description = "Blocks a card based on its card ID")
    public ResponseEntity<BlockCardResponseDTO> blockCard(@PathVariable("cardId") Long cardId) {
        BlockCardResponseDTO response = blockCardService.blockCard(cardId);
        return ResponseEntity.ok(response);
    }
}
