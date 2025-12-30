package com.rohan.inventory.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String msg) {
        super(msg);
    }
}
