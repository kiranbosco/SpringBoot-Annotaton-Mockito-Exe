package com.banking.BankingTransaction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handlerNotFoundException(CustomerNotFoundException customerNotFoundException){

        CustomerException customerException = new CustomerException(
                customerNotFoundException.getMessage(),
                customerNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(customerException,HttpStatus.NOT_FOUND);
    }

}

