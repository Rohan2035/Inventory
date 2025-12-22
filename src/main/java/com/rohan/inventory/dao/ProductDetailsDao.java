package com.rohan.inventory.dao;

import com.rohan.inventory.entity.Product;
import com.rohan.inventory.exceptions.ProductNotFoundException;
import com.rohan.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailsDao {

    private static final String PRODUCT_NOT_FOUND = "Product not found having name: ";

    @Autowired
    private ProductRepository productRepository;

    public Product findProduct(String productName) {
        return productRepository.findByProductName(productName)
                .orElseThrow(() -> new ProductNotFoundException(PRODUCT_NOT_FOUND + productName));
    }

    public void updateProductQuantity(Product product, int productQuantity) {
        product.setProductQuantity(productQuantity);
        productRepository.save(product);
    }
}
