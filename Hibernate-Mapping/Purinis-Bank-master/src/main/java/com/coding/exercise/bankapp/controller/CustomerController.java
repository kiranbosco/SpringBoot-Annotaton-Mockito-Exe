package com.coding.exercise.bankapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coding.exercise.bankapp.domain.CustomerDetails;
import com.coding.exercise.bankapp.service.BankingServiceImpl;


@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private BankingServiceImpl bankingService;

   @GetMapping("all")
    public List<CustomerDetails> findAllCustomer() throws Exception{
       return this.bankingService.findAll();
   }
   @PostMapping("/add")
    public ResponseEntity<Object> addCustomers(@RequestBody CustomerDetails customerDetails) throws Exception{
       return this.bankingService.addCustomer(customerDetails);

   }
   @PutMapping(path = "/{customerNumber}")
   public ResponseEntity<Object> updateCustomerDetails(@RequestBody CustomerDetails customerDetails, @PathVariable Long customerNumber) throws Exception{
       return this.bankingService.updateCustomer(customerDetails,customerNumber);
   }
}
