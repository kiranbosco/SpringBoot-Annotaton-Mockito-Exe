package com.purinis.BankingTransaction.service;

import com.purinis.BankingTransaction.domain.AccountInformation;
import com.purinis.BankingTransaction.domain.CustomerDetails;
import com.purinis.BankingTransaction.domain.TransactionDetails;
import com.purinis.BankingTransaction.domain.TransferDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    List<CustomerDetails> getAllCustomerDetails();

    public ResponseEntity<Object> addCustomer(CustomerDetails customerDetails) throws Exception;

    public CustomerDetails findByCustomerNumber(Long customerNumber);

    public ResponseEntity<Object> updateCustomer(CustomerDetails customerDetails, Long customerNumber);

    public ResponseEntity<Object> deleteCustomer(Long customerNumber) ;

    public ResponseEntity<Object> findByAccountNumber(Long accountNumber);

    public ResponseEntity<Object> addNewAccount(AccountInformation accountInformation, Long customerNumber);

    public ResponseEntity<Object> transferDetails(TransferDetails transferDetails, Long customerNumber);

    public List<TransactionDetails> findTransactionsByAccountNumber(Long accountNumber);

}