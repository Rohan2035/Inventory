package com.rohan.ecom.service;

import com.rohan.ecom.dto.ProductListDTO;
import com.rohan.ecom.dto.ProductResponseDTO;

public interface ProductService {
     ProductResponseDTO getProductByProductName(String name);
     ProductListDTO getProductSuggestion(String username);
}
