package com.purinisBanking.PurinisBankingApplication.domain;

import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Customer Number should not be null..!")
    private Long customerNumber;

    @NotNull(message = "Status should not be null..!")

    private String status;

    private AddressDetails customerAddress;
























    private ContactDetails contactDetails;

}