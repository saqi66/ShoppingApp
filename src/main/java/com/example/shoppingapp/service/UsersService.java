package com.example.shoppingapp.service;

import com.example.shoppingapp.dto.UsersDto;
import com.example.shoppingapp.dto.request.UsersRequest;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

public interface UsersService {
    UsersDto getUsersById(Long id);

    void saveUsers(UsersRequest usersRequest);

    void updateUsers(UsersRequest usersRequest);

    List<UsersDto> getAll();

    void deleteById(Long id);


}
