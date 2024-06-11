package com.purinis.BankingTransaction.controller;

import com.purinis.BankingTransaction.config.ConfigTest;
import com.purinis.BankingTransaction.domain.CustomerDetails;
import com.purinis.BankingTransaction.service.BankingServiceImpl;
import com.purinis.BankingTransaction.utils.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@Validated
public class CustomerControllerImpl  implements CustomerController {

    @Autowired
    private BankingServiceImpl bankingService;

    @Autowired
    private TestBean testBean;

    public CustomerControllerImpl(BankingServiceImpl bankingService) {
        this.bankingService = bankingService;
    }

    @Override
    public List<CustomerDetails> findAllCustomers() {
        testBean.methodInfo();
        return this.bankingService.findAll();
    }

    @Override
    public ResponseEntity<Object> createCustomer(CustomerDetails customerDetails) {
        return bankingService.addCustomer(customerDetails);
    }

    @Override
    public CustomerDetails findCustomerNumber(Long customerNumber) {
        return bankingService.findByCustomerNumber(customerNumber);
    }

    @Override
    public ResponseEntity<Object> updateCustomerDetails(Long customerNumber, CustomerDetails customerDetails) {
        return bankingService.updateCustomer(customerDetails,customerNumber);
    }

    @Override
    public ResponseEntity<Object> deleteCustomerData(Long customerNumber) {
        return bankingService.deleteCustomer(customerNumber);
    }
}