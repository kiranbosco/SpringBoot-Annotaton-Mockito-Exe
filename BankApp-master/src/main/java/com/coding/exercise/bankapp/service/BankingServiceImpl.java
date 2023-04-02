package com.coding.exercise.bankapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coding.exercise.bankapp.domain.AccountInformation;
import com.coding.exercise.bankapp.domain.CustomerDetails;
import com.coding.exercise.bankapp.domain.TransactionDetails;
import com.coding.exercise.bankapp.domain.TransferDetails;
import com.coding.exercise.bankapp.model.Account;
import com.coding.exercise.bankapp.model.Address;
import com.coding.exercise.bankapp.model.Contact;
import com.coding.exercise.bankapp.model.Customer;
import com.coding.exercise.bankapp.model.CustomerAccountXRef;
import com.coding.exercise.bankapp.model.Transaction;
import com.coding.exercise.bankapp.repository.AccountRepository;
import com.coding.exercise.bankapp.repository.CustomerAccountXRefRepository;
import com.coding.exercise.bankapp.repository.CustomerRepository;
import com.coding.exercise.bankapp.repository.TransactionRepository;
import com.coding.exercise.bankapp.service.helper.BankingServiceHelper;

@Service
@Transactional
public class BankingServiceImpl implements BankingService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private CustomerAccountXRefRepository customerAccountXRefRepository;
    @Autowired
    private BankingServiceHelper bankingServiceHelper;

    public BankingServiceImpl(CustomerRepository repository) {
        this.customerRepository = repository;
    }

    @Override
    public List<CustomerDetails> findAll() {
        List<CustomerDetails> allCustomerDetails = new ArrayList<>();
        Iterable<Customer> listOfCustomers = this.customerRepository.findAll();
        if (!(listOfCustomers == null)) {
            throw new RuntimeException("Data not found exception ..!");
        }
        listOfCustomers.forEach(customer -> {
            allCustomerDetails.add(bankingServiceHelper.convertToCustomerDomain(customer));
        });
        return allCustomerDetails;
    }

    @Override
    public ResponseEntity<Object> addCustomer(CustomerDetails customerDetails) {
        Customer customer = this.bankingServiceHelper.convertToCustomerEntity(customerDetails);
        customer.setCreateDateTime(new Date());
        customer.setUpdateDateTime(new Date());
        customerRepository.save(customer);
        return ResponseEntity.status(HttpStatus.OK).body("New Customer added ..!");
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
        return null;
    }
}
