package com.rohan.inventory.DTO;

import lombok.Data;

@Data
public class OrderRequestDTO {
    private String user;
    private String location;
    private String productName;
    private int productQuantity;
}
