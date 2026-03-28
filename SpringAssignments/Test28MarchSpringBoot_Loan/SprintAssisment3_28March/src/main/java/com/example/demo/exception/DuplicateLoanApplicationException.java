package com.example.demo.exception;

public class DuplicateLoanApplicationException extends RuntimeException {
    public DuplicateLoanApplicationException(String msg) {
        super(msg);
    }
}