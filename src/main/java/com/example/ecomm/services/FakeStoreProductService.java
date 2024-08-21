package com.example.ecomm.services;

import com.example.ecomm.dtos.fakestore.FakeStoreCreateProductRequestDto;
import com.example.ecomm.dtos.fakestore.FakeStoreProductResponseDto;
import com.example.ecomm.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {
    private String fakeStoreProductsApiUrl = "https://fakestoreapi.com/products";
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto fakeStoreCreateProductRequestDto = FakeStoreCreateProductRequestDto.fromProduct(product);
        FakeStoreProductResponseDto fakeStoreProductResponseDto = restTemplate.postForObject(
                fakeStoreProductsApiUrl,
                fakeStoreCreateProductRequestDto,
                FakeStoreProductResponseDto.class
        );

        return fakeStoreProductResponseDto.toProduct();
    }
}
