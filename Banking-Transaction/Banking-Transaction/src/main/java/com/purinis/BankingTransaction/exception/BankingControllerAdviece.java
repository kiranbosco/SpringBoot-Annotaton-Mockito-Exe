package com.purinis.BankingTransaction.exception;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class BankingControllerAdviece {

    @ExceptionHandler(value = {BankingRuntimeException.class})
    public ResponseEntity<Object> badRequestExceptionMsg(BankingRuntimeException bankingRuntimeException){

        BankException bankException = new BankException(
                bankingRuntimeException.getMessage(),
                HttpStatus.BAD_REQUEST,
                bankingRuntimeException.getCause()
        );

        return new  ResponseEntity<>(bankException,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlerNotFoundException(BankingRuntimeException bankingRuntimeException){
        BankException bankException = new BankException(
                bankingRuntimeException.getMessage(),
                HttpStatus.NOT_FOUND,
                bankingRuntimeException.getCause());
        return new ResponseEntity<>(bankException,HttpStatus.NOT_FOUND);
    }
}

