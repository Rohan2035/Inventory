package com.rohan.inventory.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private String productName;
    private String productDescription;
    private String productCategory;
    private String productPrice;
    private int productQuantity;
}