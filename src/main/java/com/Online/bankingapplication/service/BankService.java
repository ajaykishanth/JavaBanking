package com.Online.bankingapplication.service;

import com.Online.bankingapplication.dto.request.BankRequest;
import com.Online.bankingapplication.dto.response.BankResponse;
import java.util.List;

public interface BankService {
    BankResponse createBank(BankRequest bankRequest);
    BankResponse updateBank(String userId, BankRequest bankRequest);
    String deleteBank(String userId);
    BankResponse getBank(String userId);
    List<BankResponse> getAllBanks();
}
