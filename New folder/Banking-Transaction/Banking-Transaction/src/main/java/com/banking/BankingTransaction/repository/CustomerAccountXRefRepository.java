package com.banking.BankingTransaction.repository;
import com.banking.BankingTransaction.model.CustomerAccountXRef;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerAccountXRefRepository extends CrudRepository<CustomerAccountXRef, String> {
}