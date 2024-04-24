package com.banking.BankingTransaction.controller;

import com.banking.BankingTransaction.domain.CustomerDetails;
import com.banking.BankingTransaction.model.Customer;
import com.banking.BankingTransaction.service.BankingServiceImpl;
import com.banking.BankingTransaction.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private BankingServiceImpl bankingService;

//    @RequestMapping(value = "all",
//            consumes = {"application/json"},
//            produces = {"application/json"},
//            method = RequestMethod.GET)
    @GetMapping(value = "all",produces ={"application/json"} )
    List<CustomerDetails> getAllCustomerData(){
        return bankingService.findAll();
    }
    @PostMapping(path = "/add")
    public ResponseEntity<Object> addCustomer(@RequestBody CustomerDetails customerDetails) throws Exception{
        return this.bankingService.addCustomer(customerDetails);
    }

}
