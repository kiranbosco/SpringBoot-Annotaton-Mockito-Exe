package com.purinis.BankingTransaction.controller;

import com.purinis.BankingTransaction.domain.AccountInformation;
import com.purinis.BankingTransaction.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class AccountControllerImpl implements AccountController{

    private AccountServiceImpl accountService;

    @Autowired
    public AccountControllerImpl(AccountServiceImpl accountService){
        this.accountService=accountService;
    }

    @Override
    public ResponseEntity<Object> findAccNumber(Long accountNumber) {
        return this.accountService.findByAccountNumber(accountNumber);
    }

    @Override
    public ResponseEntity<Object> createNewAccount(Long customerNumber, AccountInformation accountInformation) {
        return this.accountService.addNewAccount(accountInformation, customerNumber);
    }


}
