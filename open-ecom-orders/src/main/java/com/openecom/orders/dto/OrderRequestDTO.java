package com.openecom.orders.dto;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequestDTO (
        String userEmail,
        String address,
        List<InnerOrderRequestDTO> orderRequests) {

    public record InnerOrderRequestDTO(
            Long productId,
            String productName,
            BigDecimal productPrice,
            int productQuantity
    ){}
}
