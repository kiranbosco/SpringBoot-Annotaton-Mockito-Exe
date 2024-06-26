package com.purinis.BankingTransaction.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ACCT_ID")
    private UUID id;

    @NotNull(message = "Account number should not be null..!")
    private Long accountNumber;

    @OneToOne(cascade=CascadeType.ALL)
    private BankInfo bankInformation;

    private String accountStatus;

    private String accountType;

    @NotNull(message = "Minimum balance 500 rupees required to open the account..!")
    private Double accountBalance;

    @Temporal(TemporalType.TIME)
    private Date createDateTime;

    @Temporal(TemporalType.TIME)
    private Date updateDateTime;
}
