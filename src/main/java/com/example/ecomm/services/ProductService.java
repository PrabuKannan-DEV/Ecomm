package com.example.ecomm.services;

import com.example.ecomm.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getProducts();
}
