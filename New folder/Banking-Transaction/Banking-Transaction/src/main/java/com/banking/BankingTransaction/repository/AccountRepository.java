package com.banking.BankingTransaction.repository;
import com.banking.BankingTransaction.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

    Optional<Account> findByAccountNumber(Long accountNumber);
}
