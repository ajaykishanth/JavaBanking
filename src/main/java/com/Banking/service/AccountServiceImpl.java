package com.Banking.service;

import com.Banking.dto.request.AccountActivationRequest;
import com.Banking.dto.response.AccountResponse;
import com.Banking.entity.Account;
import com.Banking.exception.ResourceNotFoundException;
import com.Banking.repository.accountRepository;
import com.Banking.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final accountRepository accountRepository;
    private final ModelMapper modelMapper;

	@Override
	public AccountResponse activateAccount(AccountActivationRequest request) {
		Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + request.getAccountId()));

        account.setStatus("ACTIVE");
        accountRepository.save(account);

        return modelMapper.map(account, AccountResponse.class);
	}

}
