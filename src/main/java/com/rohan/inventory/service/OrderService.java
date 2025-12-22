package com.rohan.inventory.service;

import com.rohan.inventory.dto.OrderRequestDTO;
import com.rohan.inventory.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    String addOrder(OrderRequestDTO orderRequestDTO);
    String deleteOrder(OrderRequestDTO orderRequestDTO);
    OrderResponseDTO viewOrder(String username);
    List<OrderResponseDTO> viewAllOrder(String username);
}
