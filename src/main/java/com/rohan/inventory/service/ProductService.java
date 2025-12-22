package com.rohan.inventory.service;

import com.rohan.inventory.dto.ProductRequestDTO;
import com.rohan.inventory.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
     List<ProductResponseDTO> getAllProduct();
     ProductResponseDTO getProductByProductName(String name);
     String addProduct(ProductRequestDTO requestDTO);
     String deleteProduct(String productName);
}
