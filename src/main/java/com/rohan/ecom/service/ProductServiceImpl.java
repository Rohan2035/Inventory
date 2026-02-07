package com.rohan.ecom.service;

import com.rohan.ecom.dto.ProductListDTO;
import com.rohan.ecom.dto.ProductRequestDTO;
import com.rohan.ecom.dto.ProductResponseDTO;
import com.rohan.ecom.entity.Order;
import com.rohan.ecom.entity.Product;
import com.rohan.ecom.exceptions.OpenEcomException;
import com.rohan.ecom.repository.OrderRepository;
import com.rohan.ecom.repository.ProductRepository;
import org.hibernate.query.spi.Limit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

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
                .orElseThrow(() -> new RuntimeException("Product Not Found"));

        return this.productResponseDTOMapper(product);
    }

    @Override
    public ProductListDTO getProductSuggestion(String username) {
        // Todo - Future - API Calls that will run python scripts and suggest products
        // For now - Just the DB Calls and fetch the recent products that were ordered
        List<Order> orders = orderRepository.getProducts(username, new Limit(0, 10))
                .orElseThrow(() -> new OpenEcomException("Products not found!"));
        Set<Integer> productIds = getProductsfromRecentOrders(orders);
        return null;
    }

    protected Set<Integer> getProductsfromRecentOrders(List<Order> orders) {
        return Set.of();
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

    protected Product productMapper(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setProductName(productRequestDTO.getProductName());
        product.setProductPrice(productRequestDTO.getProductPrice());
        product.setProductCategory(productRequestDTO.getProductCategory());
        product.setProductDescription(productRequestDTO.getProductDescription());
        product.setProductQuantity(productRequestDTO.getProductQuantity());

        return product;
    }
}
