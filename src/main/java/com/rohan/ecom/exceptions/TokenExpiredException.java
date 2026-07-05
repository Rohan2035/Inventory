package com.rohan.ecom.exceptions;

public class TokenExpiredException extends RuntimeException {

    public TokenExpiredException(String msg) {
        super(msg);
    }
}
