package com.rohan.inventory.service;

import com.rohan.inventory.DTO.ProductRequestDTO;
import com.rohan.inventory.DTO.ProductResponseDTO;
import com.rohan.inventory.entity.Product;

import java.util.List;

public interface ProductService {
     List<ProductResponseDTO> getAllProduct();
     List<ProductResponseDTO> getProductByProductName();
     String addProduct(ProductRequestDTO requestDTO);
     void deleteProduct(ProductRequestDTO requestDTO);
}
