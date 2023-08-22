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
public class UsersDto {

    private String username;
    private String firstName;
    private String lastName;
    private String address;
    private String telephone;
    private Date createdAt;
    private Date modifiedAt;


}
