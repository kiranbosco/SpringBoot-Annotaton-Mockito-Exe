package com.purinis.BankingTransaction.service;

import com.purinis.BankingTransaction.domain.AccountInformation;
import com.purinis.BankingTransaction.domain.CustomerDetails;
import com.purinis.BankingTransaction.domain.TransactionDetails;
import com.purinis.BankingTransaction.domain.TransferDetails;
import com.purinis.BankingTransaction.exception.BankingRuntimeException;
import com.purinis.BankingTransaction.model.Address;
import com.purinis.BankingTransaction.model.Contact;
import com.purinis.BankingTransaction.model.Customer;
import com.purinis.BankingTransaction.repository.AccountRepository;
import com.purinis.BankingTransaction.repository.CustomerAccountXRefRepository;
import com.purinis.BankingTransaction.repository.CustomerRepository;
import com.purinis.BankingTransaction.repository.TransactionRepository;
import com.purinis.BankingTransaction.utils.ApplicationConstant;
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


    private CustomerRepository customerRepository;

    private AccountRepository accountRepository;

    private TransactionRepository transactionRepository;

    private CustomerAccountXRefRepository custAccXRefRepository;

    private BankingServiceHelper bankingServiceHelper;

    @Autowired
    public BankingServiceImpl(CustomerRepository repository,
                              AccountRepository accountRepository,
                              TransactionRepository transactionRepository,
                              CustomerAccountXRefRepository customerAccountXRefRepository,
                              BankingServiceHelper bankingServiceHelper) {
        this.customerRepository=repository;
        this.bankingServiceHelper=bankingServiceHelper;
        this.custAccXRefRepository=custAccXRefRepository;
        this.transactionRepository=transactionRepository;
        accountRepository=accountRepository;

    }
    @Override
    public List<CustomerDetails> findAll() {
        List<CustomerDetails> customerDetails = new ArrayList<>();
        Iterable<Customer> customersList =this.customerRepository.findAll();

        customersList.forEach((customer -> {
            customerDetails.add(this.bankingServiceHelper.convertToCustomerDomain(customer));
        }));
        return customerDetails;
    }

    @Override
    public ResponseEntity<Object> addCustomer(CustomerDetails customerDetails) {
        Customer customer =  this.bankingServiceHelper.convertToCustomerEntity(customerDetails);
        Optional<Customer> optionalCustomer = this.customerRepository.findByCustomerNumber(customer.getCustomerNumber());
        if(!optionalCustomer.isPresent()){
            customer.setCreateDateTime(new Date());
            this.customerRepository.save(customer);
        }
        else {
            throw new BankingRuntimeException(ApplicationConstant.USER_EXISTED);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(ApplicationConstant.USER_CREATED);
    }

    @Override
    public CustomerDetails findByCustomerNumber(Long customerNumber) {
        Optional<Customer> optionalCustomer =  this.customerRepository.findByCustomerNumber(customerNumber);
        if(!optionalCustomer.isPresent()){
            throw new BankingRuntimeException(ApplicationConstant.USER_NOT_FOUND);
        }
        else {
            return this.bankingServiceHelper.convertToCustomerDomain(optionalCustomer.get());
        }
    }

    @Override
    public ResponseEntity<Object> updateCustomer(CustomerDetails customerDetails, Long customerNumber) {
        Optional<Customer> manageCustomerEntityOption = this.customerRepository.findByCustomerNumber(customerNumber);
        Customer unmanageCustomerEntity = this.bankingServiceHelper.convertToCustomerEntity(customerDetails);
        if(!manageCustomerEntityOption.isPresent()){
            throw new BankingRuntimeException(ApplicationConstant.USER_NOT_FOUND);
        }
        else {
            // if customer available update the service
            Customer manageCustomerEntity= manageCustomerEntityOption.get();
            //update
            if(Optional.ofNullable(manageCustomerEntity.getContactDetails()).isPresent()){
                Contact mangaeContact = unmanageCustomerEntity.getContactDetails();
                if(mangaeContact!=null){mangaeContact.setEmailId(mangaeContact.getEmailId());
                    mangaeContact.setEmailId(manageCustomerEntity.getContactDetails().getEmailId());
                    mangaeContact.setHomePhone(manageCustomerEntity.getContactDetails().getHomePhone());
                    mangaeContact.setHomePhone(manageCustomerEntity.getContactDetails().getHomePhone());
                }
                else {
                    unmanageCustomerEntity.setContactDetails(manageCustomerEntity.getContactDetails());
                }
                if (Optional.ofNullable(manageCustomerEntity.getCustomerAddress()).isPresent()) {
                    Address manageAddress = unmanageCustomerEntity.getCustomerAddress();
                    if(manageAddress!=null){
                        manageAddress.setAddress1(manageCustomerEntity.getCustomerAddress().getAddress1());
                        manageAddress.setAddress2(manageCustomerEntity.getCustomerAddress().getAddress2());
                        manageAddress.setState(manageCustomerEntity.getCustomerAddress().getState());
                        manageAddress.setCity(manageCustomerEntity.getCustomerAddress().getCity());
                        manageAddress.setZip(manageCustomerEntity.getCustomerAddress().getZip());
                        manageAddress.setCountry(manageCustomerEntity.getCustomerAddress().getCountry());
                    }
                    else {
                        unmanageCustomerEntity.setCustomerAddress(manageCustomerEntity.getCustomerAddress());
                    }
                    manageCustomerEntity.setUpdateDateTime(new Date());
                    manageCustomerEntity.setFirstName(unmanageCustomerEntity.getFirstName());
                    manageCustomerEntity.setMiddleName(unmanageCustomerEntity.getMiddleName());
                    manageCustomerEntity.setLastName(unmanageCustomerEntity.getLastName());
                    manageCustomerEntity.setStatus(unmanageCustomerEntity.getStatus());
                }
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(ApplicationConstant.CUSTMER_UPT);
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