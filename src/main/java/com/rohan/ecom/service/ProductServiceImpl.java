package com.rohan.ecom.service;

import com.rohan.ecom.dto.ProductListDTO;
import com.rohan.ecom.dto.ProductRequestDTO;
import com.rohan.ecom.dto.ProductResponseDTO;
import com.rohan.ecom.entity.Order;
import com.rohan.ecom.entity.Product;
import com.rohan.ecom.exceptions.OpenEcomException;
import com.rohan.ecom.exceptions.ProductNotFoundException;
import com.rohan.ecom.repository.OrderRepository;
import com.rohan.ecom.repository.ProductRepository;
import org.hibernate.query.spi.Limit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    private static final String PRODUCT_ID_NOT_FOUND = "Product not found for id: ";
    private static final String PRODUCT_NAME_NOT_FOUND = "Product not found for name: ";

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public ProductResponseDTO getProductByProductName(String productName) {
        Product product = productRepository.findByProductName(productName)
                .orElseThrow(() -> new ProductNotFoundException(PRODUCT_NAME_NOT_FOUND + productName));

        return this.productResponseDTOMapper(product);
    }

    @Override
    public ProductListDTO getProductSuggestion(String username) {
        // Todo - Future - API Calls that will run python scripts and suggest products
        // For now - Just the DB Calls and fetch the recent products that were ordered

        ProductListDTO productListDTO = new ProductListDTO();
        List<ProductResponseDTO> productList = new LinkedList<>();

        List<Order> orders = orderRepository.getProducts(username, new Limit(0, 10))
                .orElseThrow(() -> new OpenEcomException("Products not found!"));

        Set<Integer> productIds = getProductsfromRecentOrders(orders);

        for(int productId : productIds) {
            Product product = productRepository.findById(productId).orElseThrow(() ->
                    new ProductNotFoundException(PRODUCT_ID_NOT_FOUND + productId));

            productList.add(productResponseDTOMapper(product));
        }

        productListDTO.setStatus("000");
        productListDTO.setProducts(productList);

        return productListDTO;
    }

    protected Set<Integer> getProductsfromRecentOrders(List<Order> orders) {
        return orders.stream()
                .map(Order::getProductId)
                .collect(Collectors.toSet());
    }

    protected ProductResponseDTO productResponseDTOMapper(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductName(product.getProductName());
        productResponseDTO.setProductDescription(product.getProductDescription());
        productResponseDTO.setProductCategory(product.getProductCategory());
        productResponseDTO.setProductPrice(product.getProductPrice());
        productResponseDTO.setProductQuantity(product.getProductQuantity());

        return productResponseDTO;
    }
}
