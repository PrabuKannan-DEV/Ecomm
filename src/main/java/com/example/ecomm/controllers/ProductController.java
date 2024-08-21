package com.example.ecomm.controllers;

import com.example.ecomm.dtos.products.CreateProductRequestDto;
import com.example.ecomm.dtos.products.ProductResponseDto;
import com.example.ecomm.models.Product;
import com.example.ecomm.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public ProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {
        Product product = productService.createProduct(createProductRequestDto.toProduct());
        ProductResponseDto productResponseDto = new ProductResponseDto();
        return productResponseDto.fromProduct(product);
    }
}
