package com.purinisBanking.PurinisBankingApplication.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TransactionDetails {

    private Long accountNumber;

    private Date txDateTime;

    private String txType;

    private Double txAmount;
}