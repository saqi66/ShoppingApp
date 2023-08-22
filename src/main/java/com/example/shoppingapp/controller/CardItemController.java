package com.example.shoppingapp.controller;

import com.example.shoppingapp.dto.CardItemDto;
import com.example.shoppingapp.dto.request.CardItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.shoppingapp.service.CardItemService;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cardItem")
public class CardItemController {

    final CardItemService cardItemService;

    @GetMapping(value = "/cardItemList")
    public List<CardItemDto> getCardItemInfo() {

        return cardItemService.getAll();
    }

    @GetMapping(value = "/getCardItemById/{id}")
    public CardItemDto getCardItemById(@PathVariable(value = "id") Long id) {
        return  cardItemService.getCardItemById(id);
    }

    @PostMapping(value = "/saveCardItem")
    public void saveCartItem(@RequestBody CardItemRequest cartItemRequest) {
        cardItemService.saveCardItem(cartItemRequest);
    }

    @PostMapping(value = "/updateCardItem")
    public void updateCartItem(@RequestBody CardItemRequest cartItemRequest) {
        cardItemService.updateCardItem(cartItemRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {

        cardItemService.deleteById(id);
    }
}
