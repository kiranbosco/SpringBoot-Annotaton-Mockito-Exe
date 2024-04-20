package com.purinis.BankingTransaction.repository;

import com.purinis.BankingTransaction.model.CustomerAccountXRef;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerAccountXRefRepository extends CrudRepository<CustomerAccountXRef, String> {

}