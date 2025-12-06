package com.rohan.inventory.service;

import com.rohan.inventory.DTO.OrderRequestDTO;
import com.rohan.inventory.DTO.OrderResponseDTO;
import com.rohan.inventory.entity.Order;
import com.rohan.inventory.entity.Product;
import com.rohan.inventory.entity.User;
import com.rohan.inventory.repository.OrderRepository;
import com.rohan.inventory.repository.ProductRepository;
import com.rohan.inventory.repository.UserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public String addOrder(List<OrderRequestDTO> orderRequestDTOList) {
        User user = userDetailsRepository.findUserByUserName(orderRequestDTOList.get(0).getUser())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        List<Order> orderList = orderRequestDTOList.stream().map(orderRequestDTO -> {
            Product product = productRepository.findByProductName(orderRequestDTO.getProductName()).orElseThrow(
                    () -> new RuntimeException("Product not found!"));
            return mapOrder(orderRequestDTO, user, product);
        }).toList();

        orderRepository.saveAll(orderList);
        return "Success";
    }

    @Override
    public String deleteOrder(OrderRequestDTO orderRequestDTO) {
        return "";
    }

    @Override
    public OrderResponseDTO viewOrder(String username) {
        return null;
    }

    @Override
    public List<OrderResponseDTO> viewAllOrder(String username) {
        return null;
    }

    protected Order mapOrder(OrderRequestDTO orderRequestDTO, User user, Product product) {
        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now().toString());

        if(product.getProductQuantity() > 0 && product.getProductQuantity() > orderRequestDTO.getProductQuantity()) {
            order.setProduct(product);
            product.setProductQuantity(product.getProductQuantity() - orderRequestDTO.getProductQuantity());
            order.setProductQuantity(orderRequestDTO.getProductQuantity());
        } else {
            throw new RuntimeException("Quantity limit exceeded!");
        }

        order.setProductPrice(product.getProductPrice());
        order.setUserLocation(orderRequestDTO.getLocation());
        return order;
    }

    protected OrderResponseDTO mapOrderResponse(Order order) {
        return null;
    }
}
