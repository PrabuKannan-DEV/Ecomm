package com.example.ecomm.controllers;

import com.example.ecomm.dtos.products.CreateProductRequestDto;
import com.example.ecomm.dtos.products.ProductResponseDto;
import com.example.ecomm.models.Product;
import com.example.ecomm.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/{id}")
    public ProductResponseDto getProduct(@PathVariable("id") Long id) {
        Product product = productService.getProduct(id);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        return productResponseDto.fromProduct(product);
    }

    @GetMapping("")
    public List<ProductResponseDto> getProducts() {
        List<Product> products = productService.getProducts();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product : products) {
            ProductResponseDto productResponseDto = new ProductResponseDto();
            productResponseDtos.add(productResponseDto.fromProduct(product));
        }
        return productResponseDtos;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


}
