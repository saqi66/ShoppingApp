package com.example.shoppingapp.service.impl;

import com.example.shoppingapp.dto.ProductDto;
import com.example.shoppingapp.dto.request.ProductRequest;
import com.example.shoppingapp.model.Product;
import com.example.shoppingapp.repository.ProductRepository;
import com.example.shoppingapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.getProductById(id);
        return ProductDto.builder()
                .name(product.getName())
                .desk(product.getDesk())
                .SKU(product.getSKU())
                .category(product.getCategory())
                .price(product.getPrice())
                .createdAt(product.getCreatedAt())
                .modifiedAt(product.getModifiedAt())
                .build();
    }

    @Override
    public void saveProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .desk(productRequest.getDesk())
                .SKU(productRequest.getSKU())
                .category(productRequest.getCategory())
                .price(productRequest.getPrice())
                .createdAt((Date) productRequest.getCreatedAt())
                .build();

        productRepository.save(product);
    }

    @Override
    public void updateProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .desk(productRequest.getDesk())
                .SKU(productRequest.getSKU())
                .category(productRequest.getCategory())
                .price(productRequest.getPrice())
                .modifiedAt((Date) productRequest.getModifiedAt())
                .build();

        productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product : products) {
            ProductDto productDto = ProductDto.builder()
                    .name(product.getName())
                    .desk(product.getDesk())
                    .SKU(product.getSKU())
                    .category(product.getCategory())
                    .price(product.getPrice())
                    .createdAt(product.getCreatedAt())
                    .modifiedAt(product.getModifiedAt())
                    .build();

            productDtos.add(productDto);
        }

        return productDtos;
    }

    @Override
    public void deleteById(Long id) {
        Product product = productRepository.getProductById(id);
        if (product == (null)) {
            throw new RuntimeException("bele id yoxdur");

        } else {
            productRepository.deleteById(id);
        }
    }
}
