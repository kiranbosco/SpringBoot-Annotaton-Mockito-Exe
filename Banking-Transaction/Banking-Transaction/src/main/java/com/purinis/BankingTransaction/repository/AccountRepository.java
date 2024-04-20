package com.purinis.BankingTransaction.repository;

import com.purinis.BankingTransaction.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

    Optional<Account>  findByAccountNumber(Long accountNumber);
}
