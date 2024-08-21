package com.example.ecomm.services;

import com.example.ecomm.dtos.fakestore.FakeStoreCreateProductRequestDto;
import com.example.ecomm.dtos.fakestore.FakeStoreProductResponseDto;
import com.example.ecomm.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private final String fakeStoreProductsApiUrl = "https://fakestoreapi.com/products";
    private final RestTemplate restTemplate;

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

    @Override
    public List<Product> getProducts() {
        FakeStoreProductResponseDto[] fakeStoreProductResponseDtos = restTemplate.getForObject(
                fakeStoreProductsApiUrl,
                FakeStoreProductResponseDto[].class
        );

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductResponseDto fakeStoreProductResponseDto : fakeStoreProductResponseDtos) {
            products.add(fakeStoreProductResponseDto.toProduct());
        }

        return products;
    }

    @Override
    public Product getProduct(Long id) {
        FakeStoreProductResponseDto fakeStoreProductResponseDto = restTemplate.getForObject(
                fakeStoreProductsApiUrl + "/" + id,
                FakeStoreProductResponseDto.class
        );

        return fakeStoreProductResponseDto.toProduct();
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete(fakeStoreProductsApiUrl + "/" + id);
    }
}
