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
public class UsersRequest {

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String telephone;
    private Date createdAt;
    private Date modifiedAt;


}
