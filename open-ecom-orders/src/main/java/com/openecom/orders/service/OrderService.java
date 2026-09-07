package com.openecom.orders.service;

import com.openecom.orders.dto.OrderRequestDTO;
import com.openecom.orders.dto.ViewOrderRequestDTO;
import com.openecom.orders.dto.ViewOrderResponseDTO;

import java.util.Map;

public interface OrderService {
    Map<String, String> createOrder(OrderRequestDTO orderRequestDTO);
    ViewOrderResponseDTO viewOrder(ViewOrderRequestDTO orderRequestDTO);
}
