package com.rohan.inventory.service;

import com.rohan.inventory.DTO.ProductRequestDTO;
import com.rohan.inventory.DTO.ProductResponseDTO;

import java.util.List;

public interface ProductService {
     List<ProductResponseDTO> getAllProduct();
     List<ProductResponseDTO> getProductByProductName(String name);
     String addProduct(ProductRequestDTO requestDTO);
     String deleteProduct(String productName);
}
