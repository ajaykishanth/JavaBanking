
package com.Banking.repository;

import com.Banking.dto.request.TransactionRequest;
import com.Banking.dto.response.TransactionResponse;

public interface UserRepository {
    TransactionResponse processTransaction(TransactionRequest request);
}
