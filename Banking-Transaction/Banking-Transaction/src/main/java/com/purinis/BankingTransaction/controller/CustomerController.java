package com.purinis.BankingTransaction.controller;

import com.purinis.BankingTransaction.domain.CustomerDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("customers")
public interface CustomerController {

    @GetMapping(value = "/all",
            produces = {"application/json"})
    public List<CustomerDetails> findAllCustomers();

    @RequestMapping(value = "/add",
            consumes = {"application/json"},
            produces = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDetails customerDetails);

    @RequestMapping(value = "/{customerNumber}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<CustomerDetails> findCustomerNumber(@PathVariable("customerNumber") Long customerNumber);

    @RequestMapping(value = "/{customerNumber}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCustomerDetails(@PathVariable ("customerNumber")Long customerNumber,
                                                                 @RequestBody CustomerDetails customerDetails);



}
