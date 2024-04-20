package com.purinis.BankingTransaction.service;

import com.purinis.BankingTransaction.domain.AccountInformation;
import com.purinis.BankingTransaction.domain.CustomerDetails;
import com.purinis.BankingTransaction.domain.TransactionDetails;
import com.purinis.BankingTransaction.domain.TransferDetails;
import com.purinis.BankingTransaction.model.Customer;
import com.purinis.BankingTransaction.repository.AccountRepository;
import com.purinis.BankingTransaction.repository.CustomerAccountXRefRepository;
import com.purinis.BankingTransaction.repository.CustomerRepository;
import com.purinis.BankingTransaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CustomerAccountXRefRepository custAccXRefRepository;
    @Autowired
    private BankingServiceHelper bankingServiceHelper;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.customerRepository=repository;
    }

    @Override
    public List<CustomerDetails> getAllCustomerDetails() {
        List<CustomerDetails> customerDetails = new ArrayList<>();
        Iterable<Customer> customerList = this.customerRepository.findAll();
        customerList.forEach((customer -> {
            customerDetails.add(this.bankingServiceHelper.convertToCustomerDomain(customer));
        }));
        return customerDetails;
    }

    @Override
    public ResponseEntity<Object> addCustomer(CustomerDetails customerDetails) throws Exception {


        return null;
    }

    @Override
    public CustomerDetails findByCustomerNumber(Long customerNumber) {
        return null;
    }

    @Override
    public ResponseEntity<Object> updateCustomer(CustomerDetails customerDetails, Long customerNumber) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteCustomer(Long customerNumber) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findByAccountNumber(Long accountNumber) {
        return null;
    }

    @Override
    public ResponseEntity<Object> addNewAccount(AccountInformation accountInformation, Long customerNumber) {
        return null;
    }

    @Override
    public ResponseEntity<Object> transferDetails(TransferDetails transferDetails, Long customerNumber) {
        return null;
    }

    @Override
    public List<TransactionDetails> findTransactionsByAccountNumber(Long accountNumber) {
        return List.of();
    }
}
