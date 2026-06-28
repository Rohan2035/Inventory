package com.rohan.ecom.component;

import com.rohan.ecom.dto.OrderRequestDTO;
import com.rohan.ecom.entity.Order;
import com.rohan.ecom.entity.Quantity;
import com.rohan.ecom.repository.OrderRepository;
import com.rohan.ecom.repository.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OrderComponent {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private QuantityRepository reservedQuantityRepository;

    public void reserveProductQuantities(Integer id, Integer quantity) {

    }

    public void confirmOrder(List<OrderRequestDTO.InnerOrderRequestDTO> requestDTOList) {
    }

    public boolean saveAll(List<Order> orders) {
        return true;
    }
}
