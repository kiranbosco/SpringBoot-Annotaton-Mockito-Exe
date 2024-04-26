package com.purinis.BankingTransaction.service;

import com.purinis.BankingTransaction.domain.AccountInformation;
import com.purinis.BankingTransaction.domain.CustomerDetails;
import com.purinis.BankingTransaction.domain.TransactionDetails;
import com.purinis.BankingTransaction.domain.TransferDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    public List<CustomerDetails> findAll();

    public ResponseEntity<Object> addCustomer(CustomerDetails customerDetails);

    public CustomerDetails findByCustomerNumber(Long customerNumber);

    public ResponseEntity<Object> updateCustomer(CustomerDetails customerDetails, Long customerNumber);

    public ResponseEntity<Object> deleteCustomer(Long customerNumber) ;


}