package com.example.shoppingapp.service;

import com.example.shoppingapp.dto.CardItemDto;
import com.example.shoppingapp.dto.request.CardItemRequest;

import java.util.List;

public interface CardItemService {
    CardItemDto getCardItemById(Long id);

    void saveCardItem (CardItemRequest cardItemRequest);

    void updateCardItem (CardItemRequest cardItemRequest);

    List<CardItemDto>getAll();

    void deleteById(Long id);
}
