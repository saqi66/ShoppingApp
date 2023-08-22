package com.example.shoppingapp.service.impl;

import com.example.shoppingapp.dto.ShoppingSessionDto;
import com.example.shoppingapp.dto.request.ShoppingSessionRequest;
import com.example.shoppingapp.model.ShoppingSession;
import com.example.shoppingapp.repository.ShoppingSessionRepository;
import com.example.shoppingapp.service.ShoppingSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ShoppingSessionServiceImpl implements ShoppingSessionService {
    private final ShoppingSessionRepository shoppingSessionRepository;

    @Override
    public ShoppingSessionDto getShoppingSessionById(Long id) {
        ShoppingSession shoppingSession = shoppingSessionRepository.getShoppingSessionById(id);
        return ShoppingSessionDto.builder()
                .total(shoppingSession.getTotal())
                .createdAt(shoppingSession.getCreatedAt())
                .modifiedAt(shoppingSession.getModifiedAt())
                .build();
    }

    @Override
    public void saveShoppingSession(ShoppingSessionRequest shoppingSessionRequest) {
        ShoppingSession shoppingSession = ShoppingSession.builder()
                .total(shoppingSessionRequest.getTotal())
                .createdAt((Date) shoppingSessionRequest.getCreatedAt())
                .build();

        shoppingSessionRepository.save(shoppingSession);
    }

    @Override
    public void updateShoppingSession(ShoppingSessionRequest shoppingSessionRequest) {
        ShoppingSession shoppingSession = ShoppingSession.builder()
                .id(shoppingSessionRequest.getId())
                .total(shoppingSessionRequest.getTotal())
                .modifiedAt((Date) shoppingSessionRequest.getModifiedAt())
                .build();

        shoppingSessionRepository.save(shoppingSession);
    }

    @Override
    public List<ShoppingSessionDto> getAll() {
        List<ShoppingSession> shoppingSessions = shoppingSessionRepository.findAll();
        List<ShoppingSessionDto> shoppingSessionDtos = new ArrayList<>();

        for (ShoppingSession shoppingSession : shoppingSessions) {
            ShoppingSessionDto shoppingSessionDto = ShoppingSessionDto.builder()
                    .total(shoppingSession.getTotal())
                    .createdAt(shoppingSession.getCreatedAt())
                    .modifiedAt(shoppingSession.getModifiedAt())
                    .build();

            shoppingSessionDtos.add(shoppingSessionDto);
        }
        return shoppingSessionDtos;
    }

    @Override
    public void deleteById(Long id) {
        ShoppingSession shoppingSession = shoppingSessionRepository.getShoppingSessionById(id);
        if (shoppingSession == (null)) {
            throw new RuntimeException("bele id yoxdur");

        } else {
            shoppingSessionRepository.deleteById(id);
        }
    }
}
