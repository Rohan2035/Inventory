package com.rohan.inventory.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ViewOrderRequestDTO {
    private String userEmail;
    private String orderCode;
    private LocalDateTime orderDate;
}
