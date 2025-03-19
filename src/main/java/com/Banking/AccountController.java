package com.Banking;

import com.Banking.dto.request.AccountActivationRequest;
import com.Banking.dto.response.AccountResponse;
import com.Banking.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/activate")
    public ResponseEntity<AccountResponse> activateAccount(@Valid @RequestBody AccountActivationRequest request) {
        AccountResponse response = accountService.activateAccount(request);
        return ResponseEntity.ok(response);
    }
}
