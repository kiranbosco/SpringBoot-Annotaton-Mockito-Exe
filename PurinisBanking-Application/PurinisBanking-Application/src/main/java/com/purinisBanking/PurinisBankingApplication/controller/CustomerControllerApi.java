package com.purinisBanking.PurinisBankingApplication.controller;

import com.purinisBanking.PurinisBankingApplication.domain.CustomerDetails;
import com.purinisBanking.PurinisBankingApplication.service.CustomerService;
import com.purinisBanking.PurinisBankingApplication.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerControllerApi {

    @Autowired
    private CustomerService customerService;

    public CustomerControllerApi(CustomerServiceImpl customerService){
        this.customerService=customerService;
    }

    @RequestMapping(value = "/add",
            consumes = "{appliation/json}",
            produces = "{application/json}")
    public ResponseEntity<Object> createCustomer(@RequestBody  CustomerDetails customerDetails) throws Exception {
        return  customerService.addCustomer(customerDetails);

    }
}
