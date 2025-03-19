package com.Banking.service;

import com.Banking.dto.request.AccountActivationRequest;
import com.Banking.dto.response.AccountResponse;

public interface AccountService {
    AccountResponse activateAccount(AccountActivationRequest request);
}
