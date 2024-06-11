package com.purinis.BankingTransaction.controller;

import com.purinis.BankingTransaction.domain.AccountInformation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("accounts")
public interface AccountController {

    @RequestMapping(value = "/{accountNumber}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<Object> findAccNumber(@PathVariable("accountNumber") Long accountNumber);

    @RequestMapping(value = "/add/{customerNumber}",
            consumes ={"application/json"},
            produces = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Object> createNewAccount(@PathVariable("customerNumber") Long customerNumber, @RequestBody AccountInformation accountInformation);





}