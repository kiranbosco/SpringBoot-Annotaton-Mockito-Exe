package com.purinisBanking.PurinisBankingApplication.repository;


import com.purinisBanking.PurinisBankingApplication.model.CustomerAccountXRef;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountXRefRepository extends CrudRepository<CustomerAccountXRef, String> {

}