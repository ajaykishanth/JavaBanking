
package com.banking.repository;

import com.banking.dto.request.TransactionRequest;
import com.banking.dto.response.TransactionResponse;

public interface UserRepository {
    TransactionResponse processTransaction(TransactionRequest request);
}
