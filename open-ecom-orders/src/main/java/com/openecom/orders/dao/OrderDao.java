package com.openecom.orders.dao;

import com.openecom.orders.dto.OrderRequestDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class OrderDao {
    public abstract void reserveProductQuantities(Long id, Integer quantity);
    public abstract void confirmProductQuantity(List<OrderRequestDTO.InnerOrderRequestDTO> orderRequestDTOS);
    public abstract void releaseProductQuantity(List<OrderRequestDTO.InnerOrderRequestDTO> orderRequestDTOS);
    public abstract void rollbackQuantity(List<OrderRequestDTO.InnerOrderRequestDTO> requests);
}
