package com.rohan.inventory.controller;

import com.rohan.inventory.DTO.ProductResponseDTO;
import com.rohan.inventory.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProduct();
    }
}
