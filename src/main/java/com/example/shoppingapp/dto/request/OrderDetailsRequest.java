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
public class OrderDetailsRequest {

    private Long id;
    private Long userId;
    private float total;
    private Long paymentId;
    private Date createdAt;
    private Date modifiedAt;


}
