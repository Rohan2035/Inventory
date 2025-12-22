package com.rohan.inventory.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponseDTO {
    private String orderId;
    private String orderDate;
    private List<OrderProductResponseDTO> productList;
}
