package com.purinis.BankingTransaction.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="BANK_ID")
    private UUID id;

    private String branchName;

    private Integer branchCode;

    @OneToOne(cascade=CascadeType.ALL)
    private Address branchAddress;

    private Integer routingNumber;

}