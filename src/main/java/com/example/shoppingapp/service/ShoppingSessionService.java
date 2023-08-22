package com.example.shoppingapp.service;

import com.example.shoppingapp.dto.ShoppingSessionDto;
import com.example.shoppingapp.dto.request.ShoppingSessionRequest;

import java.util.List;

public interface ShoppingSessionService {

    ShoppingSessionDto getShoppingSessionById(Long id);

    void saveShoppingSession(ShoppingSessionRequest shoppingSessionRequest);

    void updateShoppingSession(ShoppingSessionRequest shoppingSessionRequest);

    List<ShoppingSessionDto> getAll();

    void deleteById(Long id);


}
