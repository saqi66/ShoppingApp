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
public class DiscountRequest {

    private Long id;
    private String name;
    private String desk;
    private float discountPercent;
    private Date createdAt;
    private Date modifiedAt;


}
