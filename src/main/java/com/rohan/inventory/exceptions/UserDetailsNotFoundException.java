package com.rohan.inventory.exceptions;

public class UserDetailsNotFoundException extends RuntimeException {
    public UserDetailsNotFoundException(String msg) {
        super(msg);
    }
}
