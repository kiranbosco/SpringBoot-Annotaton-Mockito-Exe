package com.purinisBanking.PurinisBankingApplication.service;
import com.purinisBanking.PurinisBankingApplication.domain.AccountInformation;
import com.purinisBanking.PurinisBankingApplication.domain.CustomerDetails;
import com.purinisBanking.PurinisBankingApplication.domain.TransactionDetails;
import com.purinisBanking.PurinisBankingApplication.domain.TransferDetails;
import com.purinisBanking.PurinisBankingApplication.model.Customer;
import com.purinisBanking.PurinisBankingApplication.model.CustomerAccountXRef;
import com.purinisBanking.PurinisBankingApplication.repository.AccountRepository;
import com.purinisBanking.PurinisBankingApplication.repository.CustomerAccountXRefRepository;
import com.purinisBanking.PurinisBankingApplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    CustomerAccountXRef customerAccountXRef;

    @Autowired
    CustomerAccountXRefRepository customerAccountXRefRepository;

    @Autowired
    BankingServiceHelper bankingServiceHelper;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.customerRepository=repository;
    }

    @Override
    public List<CustomerDetails> findAll() {
        return List.of();
    }

    @Override
    public ResponseEntity<Object> addCustomer(CustomerDetails customerDetails) {

        Customer customerInfo = this.bankingServiceHelper.convertToCustomerEntity(customerDetails);
        Optional<Customer> customerOptional = this.customerRepository.findByCustomerNumber(customerInfo.getCustomerNumber());

      if(customerOptional.isPresent()){
          throw new RuntimeException("Customer already existed in the bank..!");
      }
      else {
          customerInfo.setCreateDateTime(new Date());
          this.customerRepository.save(customerInfo);
      }

        return ResponseEntity.status(HttpStatus.CREATED).body("Customer has been created..!");
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

