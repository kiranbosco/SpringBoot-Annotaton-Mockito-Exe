package com.purinis.BankingTransaction.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccountXRef {
    //customer account number and account number
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="CUST_ACC_XREF_ID")
    private UUID id;

    private Long accountNumber;

    private Long customerNumber;

}