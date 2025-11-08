package com.rohan.inventory.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDTO {
    private String productName;
    private int quantity;
    private String price;
    private String orderDate;
}
