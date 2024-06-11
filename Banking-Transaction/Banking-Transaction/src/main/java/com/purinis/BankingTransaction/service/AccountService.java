package com.purinis.BankingTransaction.service;

import com.purinis.BankingTransaction.domain.AccountInformation;
import com.purinis.BankingTransaction.domain.TransactionDetails;
import com.purinis.BankingTransaction.domain.TransferDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {

    public ResponseEntity<Object> findByAccountNumber(Long accountNumber);

    public ResponseEntity<Object> addNewAccount(AccountInformation accountInformation, Long customerNumber);

    public ResponseEntity<Object> transferDetails(TransferDetails transferDetails, Long customerNumber);

    public List<TransactionDetails> findTransactionsByAccountNumber(Long accountNumber);
}
