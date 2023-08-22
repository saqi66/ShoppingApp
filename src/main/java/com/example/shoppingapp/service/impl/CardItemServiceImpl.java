package com.example.shoppingapp.service.impl;

import com.example.shoppingapp.dto.CardItemDto;
import com.example.shoppingapp.dto.request.CardItemRequest;
import com.example.shoppingapp.model.CardItem;
import com.example.shoppingapp.repository.CardItemRepository;
import com.example.shoppingapp.service.CardItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardItemServiceImpl implements CardItemService {
    private final CardItemRepository cardItemRepository;

    @Override
    public CardItemDto getCardItemById(Long id) {
        CardItem cardItem = cardItemRepository.getCardItemById(id);
        return CardItemDto.builder()
                .quantity(cardItem.getQuantity())
                .createdAt(cardItem.getCreatedAt())
                .modifiedAt(cardItem.getModifiedAt())
                .build();
    }

    @Override
    public void saveCardItem(CardItemRequest cardItemRequest) {
        CardItem cardItem = CardItem.builder()
                .quantity(cardItemRequest.getQuantity())
                .createdAt(cardItemRequest.getCreatedAt())
                .build();
        cardItemRepository.save(cardItem);

    }

    @Override
    public void updateCardItem(CardItemRequest cardItemRequest) {
        CardItem cardItem = CardItem.builder()
                .id(cardItemRequest.getId())
                .quantity(cardItemRequest.getQuantity())
                .modifiedAt(cardItemRequest.getModifiedAt())
                .build();
        cardItemRepository.save(cardItem);

    }

    @Override
    public List<CardItemDto> getAll() {
        List<CardItem> cardItem = cardItemRepository.findAll();
        List<CardItemDto> cardItemDtos = new ArrayList<>();

        for (CardItem cardItems : cardItem) {
            CardItemDto cardItemDto = CardItemDto.builder()
                    .quantity(cardItems.getQuantity())
                    .createdAt(cardItems.getCreatedAt())
                    .modifiedAt(cardItems.getModifiedAt())
                    .build();

            cardItemDtos.add(cardItemDto);
        }

        return cardItemDtos;
    }

    @Override
    public void deleteById(Long id) {
        CardItem cardItem = cardItemRepository.getCardItemById(id);
        if (cardItem == null) {
            throw new RuntimeException("ID tapilmadi.!");
        } else {
            cardItemRepository.deleteById(id);
        }
    }
}
