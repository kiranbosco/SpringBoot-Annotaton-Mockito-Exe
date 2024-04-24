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
    public class Address {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name="ADDR_ID")
        private UUID id;
        private String address1;
        private String address2;
        private String city;
        private String state;
        private String zip;
        private String country;

    }
