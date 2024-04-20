package com.purinis.BankingTransaction.domain.controller;



import com.purinis.BankingTransaction.domain.CustomerDetails;
import com.purinis.BankingTransaction.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService){
        this.customerService=customerService;
    }

    @GetMapping("all")
    public List<CustomerDetails> getALLCustomerData(){
        return  this.customerService.getAllCustomerDetails();
    }

}
