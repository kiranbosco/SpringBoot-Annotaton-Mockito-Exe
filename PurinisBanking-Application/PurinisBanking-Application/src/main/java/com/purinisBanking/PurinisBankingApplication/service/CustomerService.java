package com.purinisBanking.PurinisBankingApplication.service;

import com.purinisBanking.PurinisBankingApplication.domain.AccountInformation;
import com.purinisBanking.PurinisBankingApplication.domain.CustomerDetails;

import com.purinisBanking.PurinisBankingApplication.domain.TransactionDetails;
import com.purinisBanking.PurinisBankingApplication.domain.TransferDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService  {

    public List<CustomerDetails> findAll();

    public ResponseEntity<Object> addCustomer(CustomerDetails customerDetails);

    public CustomerDetails findByCustomerNumber(Long customerNumber);

    public ResponseEntity<Object> updateCustomer(CustomerDetails customerDetails, Long customerNumber);

    public ResponseEntity<Object> deleteCustomer(Long customerNumber) ;

    public ResponseEntity<Object> findByAccountNumber(Long accountNumber);

    public ResponseEntity<Object> addNewAccount(AccountInformation accountInformation, Long customerNumber);

    public ResponseEntity<Object> transferDetails(TransferDetails transferDetails, Long customerNumber);

    public List<TransactionDetails> findTransactionsByAccountNumber(Long accountNumber);

}