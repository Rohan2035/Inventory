package com.rohan.inventory.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String productName;
    private String productDescription;
    private String productCategory;
    private String productPrice;
    private Integer productQuantity;
}
