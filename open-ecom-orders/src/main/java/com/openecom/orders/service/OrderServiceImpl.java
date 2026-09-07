package com.openecom.orders.service;

import com.openecom.orders.dto.OrderRequestDTO;
import com.openecom.orders.dto.ViewOrderRequestDTO;
import com.openecom.orders.dto.ViewOrderResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Map<String, String> createOrder(OrderRequestDTO orderRequestDTO) {
        return Map.of();
    }

    @Override
    public ViewOrderResponseDTO viewOrder(ViewOrderRequestDTO orderRequestDTO) {
        return null;
    }
}
