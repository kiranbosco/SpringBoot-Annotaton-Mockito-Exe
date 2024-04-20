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
        //call the repository if customer number is available or not
        Optional<Customer> manageCustomerEntityRepoOpt =  this.customerRepository.findByCustomerNumber(customerNumber);
//call the service class to get the customer information
        Customer unmanageCustomerEntity = this.bankingServiceHelper.convertoCustomerEntity(customerDetails);
// check the repo if customer is available or not here?
        if(manageCustomerEntityRepoOpt.isPresent()){
            Customer manageCustomerEntity = manageCustomerEntityRepoOpt.get();
            //if yes update the customer details.
            if(Optional.ofNullable(manageCustomerEntity.getContactDetails()).isPresent()){
                Contact manageContacts = unmanageCustomerEntity.getContactDetails();
                if(manageContacts!=null){
                    manageContacts.setWorkPhone(manageCustomerEntity.getContactDetails().getWorkPhone());
                    manageContacts.setEmailId(manageCustomerEntity.getContactDetails().getHomePhone());
                    manageContacts.setWorkPhone(manageCustomerEntity.getContactDetails().getWorkPhone());
                }
                else {
                    manageCustomerEntity.setContactDetails(unmanageCustomerEntity.getContactDetails());
                }
                if(Optional.ofNullable(manageCustomerEntity.getCustomerAddress()).isPresent()){
                    Address address = manageCustomerEntity.getCustomerAddress();
                    if(address!=null){
                        address.setState(manageCustomerEntity.getCustomerAddress().getState());
                        address.setCity(manageCustomerEntity.getCustomerAddress().getCity());
                        address.setAddress2(manageCustomerEntity.getCustomerAddress().getAddress2());
                        address.setAddress1(manageCustomerEntity.getCustomerAddress().getAddress1());
                        address.setCountry(manageCustomerEntity.getCustomerAddress().getCountry());
                        address.setZip(manageCustomerEntity.getCustomerAddress().getZip());
                    }
                    else {
                        manageCustomerEntity.setCustomerAddress(unmanageCustomerEntity.getCustomerAddress());
                    }
                    manageCustomerEntity.setFirstName(unmanageCustomerEntity.getFirstName());
                    manageCustomerEntity.setLastName(unmanageCustomerEntity.getLastName());
                    manageCustomerEntity.setMiddleName(unmanageCustomerEntity.getMiddleName());
                    manageCustomerEntity.setAdhar_number(unmanageCustomerEntity.getAdhar_number());
                    manageCustomerEntity.setStatus(unmanageCustomerEntity.getStatus());
                    manageCustomerEntity.setUpdateDateTime(unmanageCustomerEntity.getUpdateDateTime());
                    customerRepository.save(manageCustomerEntity);
                }
                return ResponseEntity.status(HttpStatus.OK).body("Customer details has been updated..!");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer is not available" + customerDetails);
    }
    @Override
    public ResponseEntity<Object> deleteCustomer(Long customerNumber) {
        //find if the customer is available or not?
      Optional<Customer> deleteCustomer =  this.customerRepository.findByCustomerNumber(customerNumber);
      if(!deleteCustomer.isPresent()){
          throw new RuntimeException("Customer is not available");
      }
      else {
          Customer customerInfor = deleteCustomer.get();
          this.customerRepository.delete(customerInfor);
      }
        return ResponseEntity.status(HttpStatus.OK).body("Customer has been successfully deleted..!");
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
