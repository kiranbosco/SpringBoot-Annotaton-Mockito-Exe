package com.purinis.BankingTransaction.repository;
import java.util.List;
import java.util.Optional;

import com.purinis.BankingTransaction.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {

    public Optional<List<Transaction>> findByAccountNumber(Long accountNumber);

}