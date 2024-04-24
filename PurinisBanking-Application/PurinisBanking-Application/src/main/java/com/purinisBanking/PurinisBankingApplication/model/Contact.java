package com.purinisBanking.PurinisBankingApplication.model;

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
public class Contact {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="CONTACT_ID")
    private UUID id;

    private String emailId;

    private String homePhone;

    private String workPhone;

}