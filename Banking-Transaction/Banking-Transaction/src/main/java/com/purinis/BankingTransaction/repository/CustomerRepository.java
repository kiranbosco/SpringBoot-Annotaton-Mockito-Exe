package com.purinis.BankingTransaction.repository;

import java.util.Optional;

import com.purinis.BankingTransaction.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    public Optional<Customer> findByCustomerNumber(Long customerNumber);
}