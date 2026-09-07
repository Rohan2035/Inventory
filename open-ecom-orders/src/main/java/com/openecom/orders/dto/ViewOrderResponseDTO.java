package com.openecom.orders.dto;

import java.time.LocalDate;
import java.util.List;

public record ViewOrderResponseDTO (
         int status,
         String statusMessage,
         String orderedBy,
         List<OrderResponseDTO> orders
){

    public record OrderResponseDTO(
            String orderCode,
            LocalDate orderDate,
            List<OrderProductResponseDTO> products
    ) {

        public record OrderProductResponseDTO(
                String productName,
                String productDescription,
                String productCategory,
                String productPrice,
                int productQuantity
        ) {}
    }
}
