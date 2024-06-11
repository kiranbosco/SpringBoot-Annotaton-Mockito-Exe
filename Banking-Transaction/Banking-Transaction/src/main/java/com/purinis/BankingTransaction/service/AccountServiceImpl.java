package com.purinis.BankingTransaction.service;

import com.purinis.BankingTransaction.domain.AccountInformation;
import com.purinis.BankingTransaction.domain.TransactionDetails;
import com.purinis.BankingTransaction.domain.TransferDetails;
import com.purinis.BankingTransaction.exception.BankingRuntimeException;
import com.purinis.BankingTransaction.model.Account;
import com.purinis.BankingTransaction.model.Customer;
import com.purinis.BankingTransaction.model.CustomerAccountXRef;
import com.purinis.BankingTransaction.repository.AccountRepository;
import com.purinis.BankingTransaction.repository.CustomerAccountXRefRepository;
import com.purinis.BankingTransaction.repository.CustomerRepository;
import com.purinis.BankingTransaction.repository.TransactionRepository;
import com.purinis.BankingTransaction.utils.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;
    private CustomerAccountXRefRepository customerAccountXRefRepository;
    private BankingServiceHelper bankingServiceHelper;
    private CustomerRepository customerRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,
                              TransactionRepository transactionRepository,
                              CustomerRepository customerRepository,
                              CustomerAccountXRefRepository customerAccountXRefRepository,
                              BankingServiceHelper bankingServiceHelper){


        this.accountRepository=accountRepository;
        this.customerRepository=customerRepository;
        this.customerAccountXRefRepository=customerAccountXRefRepository;
        this.transactionRepository=transactionRepository;
        this.bankingServiceHelper=bankingServiceHelper;
    }

    @Override
    public ResponseEntity<Object> findByAccountNumber(Long accountNumber) {
        //call the account repository for checking acc
        Optional<Account> accountOptional = this.accountRepository.findByAccountNumber(accountNumber);
        if(!accountOptional.isPresent()){
            throw new BankingRuntimeException(ApplicationConstant.ACC_NOT_FND);
        }
        else {
            this.bankingServiceHelper.convertToAccountDomain(accountOptional.get());
        }
        return ResponseEntity.status(HttpStatus.OK).body(accountNumber);
    }

    @Override
    public ResponseEntity<Object> addNewAccount(AccountInformation accountInformation, Long customerNumber) {
// check if the customer number is available or not?
        Optional<Customer> optionalCustomer = this.customerRepository.findByCustomerNumber(customerNumber);
        Optional<Account> optionalAccount = this.accountRepository.findByAccountNumber(accountInformation.getAccountNumber());
        if(!optionalCustomer.isPresent()){
            throw new BankingRuntimeException(ApplicationConstant.USER_EXISTED);
        } else if (optionalAccount.isPresent()) {
            throw new BankingRuntimeException(ApplicationConstant.USER_EXISTED);
        } else {

            accountRepository.save(this.bankingServiceHelper.convertToAccountEntity(accountInformation));
            // call the customerXrepo details and save
            this.customerAccountXRefRepository.save(CustomerAccountXRef.builder()
                    .accountNumber(accountInformation.getAccountNumber())
                    .customerNumber(customerNumber).build());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(ApplicationConstant.ACCOUNT_CREATED_SUCCESS);
    }

    @Override
    public ResponseEntity<Object> transferDetails(TransferDetails transferDetails, Long customerNumber) {
        return null;
    }

    @Override
    public List<TransactionDetails> findTransactionsByAccountNumber(Long accountNumber) {
        return List.of();
    }
}
