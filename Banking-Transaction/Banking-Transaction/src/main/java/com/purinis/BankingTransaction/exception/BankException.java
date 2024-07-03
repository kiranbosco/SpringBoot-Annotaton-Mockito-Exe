package com.purinis.BankingTransaction.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class BankException {

    private  final String message;
    private final HttpStatus httpStatus;
    private final  Throwable throwable;


    public BankException(String message, HttpStatus httpStatus, Throwable throwable) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.throwable = throwable;
    }
}
