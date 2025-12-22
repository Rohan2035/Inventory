package com.rohan.inventory.service;

import com.rohan.inventory.dao.ProductDetailsDao;
import com.rohan.inventory.dto.OrderRequestDTO;
import com.rohan.inventory.dto.OrderResponseDTO;
import com.rohan.inventory.entity.Order;
import com.rohan.inventory.entity.Product;
import com.rohan.inventory.entity.User;
import com.rohan.inventory.exceptions.ProductQuantityExceededException;
import com.rohan.inventory.exceptions.UserDetailsNotFoundException;
import com.rohan.inventory.repository.OrderRepository;
import com.rohan.inventory.repository.UserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);
    private static final String USER_NOT_FOUND_MSG = "User Details not found for email: ";
    private static final String PRODUCT_QUANTITY_MSG = "Product Quantity Exceeded for product: ";

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private ProductDetailsDao productDetailsDao;

    @Override
    public String addOrder(OrderRequestDTO orderRequestDTO) {
        User user = userDetailsRepository.findByEmail(orderRequestDTO.getUserEmail())
                .orElseThrow(() -> new UserDetailsNotFoundException(USER_NOT_FOUND_MSG +
                        orderRequestDTO.getUserEmail()));

        List<OrderRequestDTO.InnerOrderRequestDTO> orderRequests = orderRequestDTO.getOrderRequests();
        List<Order> orders = orderRequests.stream()
                .map(orderRequest -> {
                    Product product = productDetailsDao.findProduct(orderRequest.getProductName());
                    if(orderRequest.getProductQuantity() > product.getProductQuantity()) {
                        throw new ProductQuantityExceededException(
                                PRODUCT_QUANTITY_MSG + orderRequest.getProductName());
                    }
                    int quantityLeft = product.getProductQuantity() - orderRequest.getProductQuantity();
                    productDetailsDao.updateProductQuantity(product, quantityLeft);
                    return this.mapOrder(orderRequest, user, product);
                })
                .toList();
        orderRepository.saveAll(orders);

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

    protected Order mapOrder(OrderRequestDTO.InnerOrderRequestDTO orderRequestDTO, User user, Product product) {
        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setProductPrice(orderRequestDTO.getProductPrice());
        order.setProductQuantity(orderRequestDTO.getProductQuantity());
        order.setOrderDate(LocalDateTime.now().toString());
        return order;
    }

    protected OrderResponseDTO mapOrderResponse(Order order) {
        return null;
    }
}
