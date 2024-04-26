package com.purinis.BankingTransaction.controller;

import com.purinis.BankingTransaction.domain.CustomerDetails;
import com.purinis.BankingTransaction.service.BankingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@Validated
public class CustomerControllerImpl  implements CustomerController {

    @Autowired
    private BankingServiceImpl bankingService;


    public CustomerControllerImpl(BankingServiceImpl bankingService) {
        this.bankingService = bankingService;
    }

    @Override
    public List<CustomerDetails> findAllCustomers() {
        return this.bankingService.findAll();
    }

    @Override
    public ResponseEntity<Object> createCustomer(CustomerDetails customerDetails) {
        return bankingService.addCustomer(customerDetails);
    }

    @Override
    public ResponseEntity<CustomerDetails> findCustomerNumber(Long customerNumber) {
        return new ResponseEntity<>(this.bankingService.findByCustomerNumber(customerNumber), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> updateCustomerDetails(Long customerNumber, CustomerDetails customerDetails) {
        return new ResponseEntity<>(this.bankingService.updateCustomer(customerDetails,customerNumber),HttpStatus.OK);
    }
}