package com.rohan.inventory.service;

import com.rohan.inventory.DTO.ProductRequestDTO;
import com.rohan.inventory.DTO.ProductResponseDTO;
import com.rohan.inventory.entity.Product;
import com.rohan.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductResponseDTO> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        System.out.println("Product List: " + productList);
        return productList.stream()
                .map(this::productMapper)
                .toList();
    }

    @Override
    public List<ProductResponseDTO> getProductByProductName() {
        return List.of();
    }

    @Override
    public String addProduct(ProductRequestDTO requestDTO) {
        return "";
    }

    @Override
    public void deleteProduct(ProductRequestDTO requestDTO) {

    }

    protected ProductResponseDTO productMapper(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductName(product.getProductName());
        productResponseDTO.setProductDescription(product.getProductDescription());
        productResponseDTO.setProductCategory(product.getProductCategory());
        productResponseDTO.setProductPrice(product.getProductPrice());
        productResponseDTO.setProductQuantity(product.getProductQuantity());
        return productResponseDTO;
    }
}
