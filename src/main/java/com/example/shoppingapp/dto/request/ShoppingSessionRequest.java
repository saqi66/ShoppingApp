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
public class ShoppingSessionRequest {

    private Long id;
    private Long userId;
    private float total;
    private Date createdAt;
    private Date modifiedAt;

}
