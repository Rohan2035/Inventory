package com.rohan.inventory.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    private String productName;
    private String quantity;
}
