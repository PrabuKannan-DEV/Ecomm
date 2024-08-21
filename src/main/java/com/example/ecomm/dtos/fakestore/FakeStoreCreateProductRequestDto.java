package com.example.ecomm.dtos.fakestore;

import com.example.ecomm.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductRequestDto {
    private String title;
    private String description;
    private Double price;
    private String category;
    private String image;

    public static FakeStoreCreateProductRequestDto fromProduct(Product product) {
        FakeStoreCreateProductRequestDto requestDto = new FakeStoreCreateProductRequestDto();
        requestDto.setTitle(product.getTitle());
        requestDto.setDescription(product.getDescription());
        requestDto.setPrice(product.getPrice());
        requestDto.setCategory(product.getCategory());
        requestDto.setImage(product.getImageUrl());
        return requestDto;
    }
}
