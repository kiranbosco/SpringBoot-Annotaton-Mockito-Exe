package com.purinis.BankingTransaction.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDetails {

    private String firstName;

    private String lastName;

    private String middleName;

    private Long customerNumber;

    private String status;

    private AddressDetails customerAddress;
























    private ContactDetails contactDetails;

}