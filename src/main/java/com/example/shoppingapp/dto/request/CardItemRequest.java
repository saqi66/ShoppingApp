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
public class CardItemRequest {
    private Long id;
    private Long sessionId;
    private Long productId;
    private Long quantity;
    private Date createdAt;
    private Date modifiedAt;

}
