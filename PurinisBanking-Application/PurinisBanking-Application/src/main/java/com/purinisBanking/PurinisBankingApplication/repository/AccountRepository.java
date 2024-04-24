package com.purinisBanking.PurinisBankingApplication.repository;
import com.purinisBanking.PurinisBankingApplication.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

    Optional<Account>  findByAccountNumber(Long accountNumber);
}
