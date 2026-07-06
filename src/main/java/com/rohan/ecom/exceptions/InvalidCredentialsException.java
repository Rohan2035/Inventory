package com.rohan.ecom.exceptions;

public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException(String msg) {
        super(msg);
    }

    public InvalidCredentialsException(Exception e) {
        super(e);
    }
}
