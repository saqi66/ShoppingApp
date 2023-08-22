package com.example.shoppingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String name;
    private String desk;
    private String SKU;
    private String category;
    private float price;
    private Date createdAt;
    private Date modifiedAt;

}
