package com.rohan.inventory.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderNativeQueryResponseDTO {
    private String orderCode;
    private LocalDateTime orderDate;
    private Integer productOrderedQuantity;
    private Integer productOrderedPrice;
    private Integer productName;
    private Integer productDescription;
    private Integer productCategory;
}
