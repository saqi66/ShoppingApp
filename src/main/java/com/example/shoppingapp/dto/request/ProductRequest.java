package com.example.shoppingapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private Long id;
    private String name;
    private String desk;
    private String SKU;
    private String category;
    private float price;
    private Long discountId;
    private Date createdAt;
    private Date modifiedAt;

}
