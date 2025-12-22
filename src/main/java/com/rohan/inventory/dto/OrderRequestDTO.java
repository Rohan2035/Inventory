package com.rohan.inventory.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {
    private String userEmail;
    private List<InnerOrderRequestDTO> orderRequests;

    @Data
    public static class InnerOrderRequestDTO {
        private String productName;
        private String productPrice;
        private int productQuantity;
    }
}
