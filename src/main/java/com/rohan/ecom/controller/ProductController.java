package com.rohan.ecom.controller;

import com.rohan.ecom.dto.ProductListDTO;
import com.rohan.ecom.dto.ProductRequestDTO;
import com.rohan.ecom.dto.ProductResponseDTO;
import com.rohan.ecom.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/getproductname")
    public ProductResponseDTO getProductName(@RequestParam("productName") String productName) {
        return productService.getProductByProductName(productName);
    }

    @PostMapping("/productsuggestion")
    public ProductListDTO getProductSuggestions(@RequestParam("username") String username) {
        productService.getProductSuggestion(username);
        return null;
    }
}
