package com.banking.BankingTransaction.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class AddressDetails {

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;

}