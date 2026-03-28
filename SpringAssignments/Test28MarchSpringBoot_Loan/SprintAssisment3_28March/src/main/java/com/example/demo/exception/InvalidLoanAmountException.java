package com.example.demo.exception;

public class InvalidLoanAmountException extends RuntimeException {
    public InvalidLoanAmountException(String msg) {
        super(msg);
    }
}