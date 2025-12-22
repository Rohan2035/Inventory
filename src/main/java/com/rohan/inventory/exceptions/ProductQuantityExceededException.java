package com.rohan.inventory.exceptions;

public class ProductQuantityExceededException extends RuntimeException {
    public ProductQuantityExceededException(String msg) {
        super(msg);
    }
}
