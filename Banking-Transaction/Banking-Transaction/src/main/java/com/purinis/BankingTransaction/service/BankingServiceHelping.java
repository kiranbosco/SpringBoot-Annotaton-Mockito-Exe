package com.purinis.BankingTransaction.service;

import com.purinis.BankingTransaction.domain.*;
import com.purinis.BankingTransaction.model.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BankingServiceHelping {

    public CustomerDetails convertCustomerDomain(Customer customer) {
        return CustomerDetails.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .middleName(customer.getMiddleName())
                .status(customer.getStatus())
                .contactDetails(convcertToContactDomain(customer.getContactDetails()))
                .customerAddress(convertAddressDomain(customer.getCustomerAddress()))
                .build();
    }
    public Customer convertToCustomerEntity(CustomerDetails customerDetails){
        return Customer.builder()
                .customerNumber(customerDetails.getCustomerNumber())
                .firstName(customerDetails.getFirstName())
                .middleName(customerDetails.getMiddleName())
                .lastName(customerDetails.getLastName())
                .createDateTime(new Date())
                .status(customerDetails.getStatus())
                .updateDateTime(new Date())
                .customerAddress(convertAddressEntity(customerDetails.getCustomerAddress()))
                .contactDetails(convertTOContactEntity(customerDetails.getContactDetails()))
                .build();
    }
    public ContactDetails convcertToContactDomain(Contact contact){
        return ContactDetails.builder()
                .emailId(contact.getEmailId())
                .homePhone(contact.getHomePhone())
                .workPhone(contact.getWorkPhone())
                .build();
    }
    public Contact convertTOContactEntity(ContactDetails contactDetails){
        return Contact.builder()
                .homePhone(contactDetails.getHomePhone())
                .homePhone(contactDetails.getHomePhone())
                .workPhone(contactDetails.getWorkPhone())
                .build();
    }
    public AddressDetails convertAddressDomain(Address address){
        return AddressDetails.builder()
                .address2(address.getAddress2())
                .address1(address.getAddress1())
                .zip(address.getZip())
                .state(address.getState())
                .country(address.getCountry())
                .city(address.getCity())
                .build();
    }
    public Address convertAddressEntity(AddressDetails addressDetails){
        return Address.builder()
                .address2(addressDetails.getAddress2())
                .address1(addressDetails.getAddress1())
                .state(addressDetails.getState())
                .city(addressDetails.getCity())
                .zip(addressDetails.getZip())
                .country(addressDetails.getCountry())
                .build();
    }
    public AccountInformation convvertAccountDomain(Account account){
        return AccountInformation.builder()
                .accountNumber(account.getAccountNumber())
                .accountBalance(account.getAccountBalance())
                .accountCreated(new Date())
                .accountStatus(account.getAccountStatus())
                .bankInformation(convertTOBankDomain(account.getBankInformation()))
                .accountType(account.getAccountType())
                .build();
    }
    public Account convertToAccountEntity(AccountInformation accountInformation){
        return Account.builder()
                .accountNumber(accountInformation.getAccountNumber())
                .accountBalance(accountInformation.getAccountBalance())
                .accountStatus(accountInformation.getAccountStatus())
                .accountType(accountInformation.getAccountType())
                .createDateTime(new Date())
                .updateDateTime(new Date())
                .bankInformation(convertToBankInfoEntity(accountInformation.getBankInformation()))
                .build();
    }
    public BankInformation convertTOBankDomain(BankInfo bankInfo){
        return BankInformation.builder()
                .branchAddress(convertAddressDomain(bankInfo.getBranchAddress()))
                .branchCode(bankInfo.getBranchCode())
                .routingNumber(bankInfo.getRoutingNumber())
                .branchName(bankInfo.getBranchName())
                .build();
    }
    public BankInfo convertToBankInfoEntity(BankInformation bankInformation){
        return BankInfo.builder()
                .branchAddress(convertAddressEntity(bankInformation.getBranchAddress()))
                .branchCode(bankInformation.getBranchCode())
                .branchName(bankInformation.getBranchName())
                .routingNumber(bankInformation.getRoutingNumber())
                .build();
    }
    public TransactionDetails convertToTransactionDomain(Transaction transaction){
        return TransactionDetails.builder()
                .accountNumber(transaction.getAccountNumber())
                .txAmount(transaction.getTxAmount())
                .txType(transaction.getTxType())
                .txDateTime(new Date())
                .build();
    }
    public Transaction convertToTranactionEntity(TransactionDetails transactionDetails){
        return Transaction.builder()
                .accountNumber(transactionDetails.getAccountNumber())
                .txType(transactionDetails.getTxType())
                .txAmount(transactionDetails.getTxAmount())
                .txDateTime(new Date())
                .build();
    }
    public Transaction createTrasaction(TransactionDetails transactionDetails, Long accountNumber,String txType){
        return  Transaction.builder()
                .accountNumber(accountNumber)
                .txType(txType)
                .txDateTime(new Date())
                .txAmount(transactionDetails.getTxAmount())
                .build();
    }
}