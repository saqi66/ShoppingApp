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
public class PaymentDetailsRequest {

    private Long id;
    private Long orderId;
    private float amount;
    private String provider;
    private String status;
    private Date createdAt;
    private Date modifiedAt;

}
