package com.purinis.BankingTransaction.exception;

public class BankingRuntimeException extends RuntimeException {

    public BankingRuntimeException(String message) {
        super(message);
    }

    public BankingRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
