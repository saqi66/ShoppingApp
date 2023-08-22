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
public class PaymentDetailsDto {
    private float amount;
    private String provider;
    private String status;
    private Date createdAt;
    private Date modifiedAt;


}
