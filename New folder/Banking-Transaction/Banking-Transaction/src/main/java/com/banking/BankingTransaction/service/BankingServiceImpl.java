package com.banking.BankingTransaction.service;

import com.banking.BankingTransaction.domain.AccountInformation;
import com.banking.BankingTransaction.domain.CustomerDetails;
import com.banking.BankingTransaction.domain.TransactionDetails;
import com.banking.BankingTransaction.domain.TransferDetails;
import com.banking.BankingTransaction.exception.CustomerNotFoundException;
import com.banking.BankingTransaction.model.Customer;
import com.banking.BankingTransaction.repository.AccountRepository;
import com.banking.BankingTransaction.repository.CustomerAccountXRefRepository;
import com.banking.BankingTransaction.repository.CustomerRepository;
import com.banking.BankingTransaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BankingServiceImpl implements CustomerService {

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

    public BankingServiceImpl(CustomerRepository repository) {
        this.customerRepository=repository;
    }


    @Override
    public List<CustomerDetails> findAll() {
        List<CustomerDetails> customerList = new ArrayList<>();
        Iterable<Customer> customerIterable = this.customerRepository.findAll();
        customerIterable.forEach((customer -> {
            customerList.add(this.bankingServiceHelper.convertToCustomerDomain(customer));
        }));

        return customerList;
    }

    @Override
    public ResponseEntity<Object> addCustomer(CustomerDetails customerDetails) {
      Customer customer =  this.bankingServiceHelper.convertToCustomerEntity(customerDetails);
        Optional<Customer> customerOptional=  this.customerRepository.findByCustomerNumber(customerDetails.getCustomerNumber());
       if(customerOptional.isPresent()){
           throw new CustomerNotFoundException("Customer already existed..!");
       }
       else {
           customer.setCreateDateTime(new Date());
           this.customerRepository.save(customer);
       }
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer successfully added..!");
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