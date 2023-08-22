package com.example.shoppingapp.service;

import com.example.shoppingapp.dto.ProductDto;
import com.example.shoppingapp.dto.request.ProductRequest;

import java.util.List;

public interface ProductService {
    ProductDto getProductById(Long id);

    void saveProduct(ProductRequest productRequest);

    void updateProduct(ProductRequest productRequest);

    List<ProductDto> getAll();

    void deleteById(Long id);

}
