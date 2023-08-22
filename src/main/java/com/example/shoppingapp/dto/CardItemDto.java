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
public class CardItemDto {
    private Long quantity;
    private Date createdAt;
    private Date modifiedAt;

}
