package com.coding.exercise.bankapp.service;

import com.coding.exercise.bankapp.domain.AccountInformation;
import com.coding.exercise.bankapp.domain.CustomerDetails;
import com.coding.exercise.bankapp.domain.TransactionDetails;
import com.coding.exercise.bankapp.domain.TransferDetails;
import com.coding.exercise.bankapp.model.Address;
import com.coding.exercise.bankapp.model.Contact;
import com.coding.exercise.bankapp.model.Customer;
import com.coding.exercise.bankapp.repository.AccountRepository;
import com.coding.exercise.bankapp.repository.CustomerAccountXRefRepository;
import com.coding.exercise.bankapp.repository.CustomerRepository;
import com.coding.exercise.bankapp.repository.TransactionRepository;
import com.coding.exercise.bankapp.service.helper.BankingServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BankingServiceImpl implements BankingService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerAccountXRefRepository customerAccountXRefRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    BankingServiceHelper bankingServiceHelper;



    public BankingServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository=customerRepository;
    }

    @Override
    public List<CustomerDetails> findAll() throws Exception {
        List<CustomerDetails> customerDetails = new ArrayList<>();
        Iterable<Customer> customerList = this.customerRepository.findAll();
        if(customerList!=null){
            customerList.forEach((customer -> {
                customerDetails.add(this.bankingServiceHelper.convertToCustomerDomain(customer));
            }));
        }

        return customerDetails;
    }

    @Override
    public ResponseEntity<Object> addCustomer(CustomerDetails customerDetails) throws Exception {
        //call the service
        Customer customer = this.bankingServiceHelper.convertoCustomerEntity(customerDetails);
        //check weather the Customer Number already existed or not
        if(customerRepository.findByCustomerNumber(customer.getCustomerNumber()).isPresent()){
            throw new RuntimeException("Customer already existed please use different CustomerNumber..!");
        }
        else {
            customer.setCreateDateTime(new Date());
            this.customerRepository.save(customer);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Account has been created successfully..!");
    }

    @Override
    public CustomerDetails findByCustomerNumber(Long customerNumber) throws Exception {
        Optional<Customer> customer = this.customerRepository.findByCustomerNumber(customerNumber);
        if(!customer.isPresent()){
            throw new RuntimeException("Customer Id does not existed..!");
        }
        return bankingServiceHelper.convertToCustomerDomain(customer.get());
    }

    @Override
    public ResponseEntity<Object> updateCustomer(CustomerDetails customerDetails, Long customerNumber) {
//call the repository
        Optional<Customer> manageCustomerEntityOpt =  this.customerRepository.findByCustomerNumber(customerNumber);
        // call the service
        Customer unmanageCustomerEntity =  this.bankingServiceHelper.convertoCustomerEntity(customerDetails);
        // check if the customer is available or not?
        if(manageCustomerEntityOpt.isPresent()){
            Customer manageCustomerEntity = manageCustomerEntityOpt.get();

            //update the service
            if(Optional.ofNullable(unmanageCustomerEntity.getContactDetails()).isPresent()){
                Contact manageContact = manageCustomerEntity.getContactDetails();
                if(manageContact!=null){
                    manageContact.setEmailId(manageCustomerEntity.getContactDetails().getEmailId());
                    manageContact.setHomePhone(manageCustomerEntity.getContactDetails().getHomePhone());
                    manageContact.setWorkPhone(manageCustomerEntity.getContactDetails().getWorkPhone());
                }
                else {
                    manageCustomerEntity.setContactDetails(unmanageCustomerEntity.getContactDetails());
                }
                if(Optional.ofNullable(unmanageCustomerEntity.getCustomerAddress()).isPresent()){
                    Address manageAddress = manageCustomerEntity.getCustomerAddress();
                    if(manageAddress!=null){
                        manageAddress.setCountry(manageCustomerEntity.getCustomerAddress().getCountry());
                        manageAddress.setCity(manageCustomerEntity.getCustomerAddress().getCity());
                        manageAddress.setZip(manageCustomerEntity.getCustomerAddress().getZip());
                        manageAddress.setAddress1(manageCustomerEntity.getCustomerAddress().getAddress1());
                        manageAddress.setAddress2(manageCustomerEntity.getCustomerAddress().getAddress2());
                        manageAddress.setState(manageCustomerEntity.getCustomerAddress().getState());
                    }
                    else {
                        manageCustomerEntity.setCustomerAddress(unmanageCustomerEntity.getCustomerAddress());
                    }
                    manageCustomerEntity.setStatus(unmanageCustomerEntity.getStatus());
                    manageCustomerEntity.setLastName(unmanageCustomerEntity.getLastName());
                    manageCustomerEntity.setFirstName(unmanageCustomerEntity.getFirstName());
                    manageCustomerEntity.setLastName(unmanageCustomerEntity.getLastName());
                    manageCustomerEntity.setCreateDateTime(new Date());
                    this.customerRepository.save(manageCustomerEntity);
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body("Customer details updated..!");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer number "+ customerDetails + "Not found");
    }

    @Override
    public ResponseEntity<Object> deleteCustomer(Long customerNumber) {
        return null;
    }

    @Override
    public ResponseEntity<Object> softDeleteCustomerId(Long customerNumber) throws Exception {
        return null;
    }

    @Override
    public AccountInformation findByAccountNumber(Long accountNumber) throws Exception {
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
        return Collections.emptyList();
    }
}
