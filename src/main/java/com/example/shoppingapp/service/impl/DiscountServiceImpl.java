package com.example.shoppingapp.service.impl;

import com.example.shoppingapp.dto.DiscountDto;
import com.example.shoppingapp.dto.request.DiscountRequest;
import com.example.shoppingapp.model.Discount;
import com.example.shoppingapp.repository.DiscountRepository;
import com.example.shoppingapp.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    @Override
    public DiscountDto getDiscountById(Long id) {
        Discount discount = discountRepository.getDiscountById(id);
        return DiscountDto.builder()
                .name(discount.getName())
                .desk(discount.getDesk())
                .discountPercent(discount.getDiscountPercent())
                .createdAt(discount.getCreatedAt())
                .modifiedAt(discount.getModifiedAt())
                .build();
    }

    @Override
    public void saveDiscount(DiscountRequest discountRequest) {
        Discount discount = Discount.builder()
                .name(discountRequest.getName())
                .desk(discountRequest.getDesk())
                .discountPercent(discountRequest.getDiscountPercent())
                .createdAt(discountRequest.getCreatedAt())
                .build();

        discountRepository.save(discount);
    }

    @Override
    public void updateDiscount(DiscountRequest discountRequest) {
        Discount discount = Discount.builder()
                .id(discountRequest.getId())
                .name(discountRequest.getName())
                .discountPercent(discountRequest.getDiscountPercent())
                .desk(discountRequest.getDesk())
                .modifiedAt(discountRequest.getModifiedAt())
                .build();
        discountRepository.save(discount);
    }

    @Override
    public List<DiscountDto> getAll() {
        List<Discount> discount = discountRepository.findAll();
        List<DiscountDto> discountDtos = new ArrayList<>();

        for (Discount discounts : discount) {
            DiscountDto discountDto = DiscountDto.builder()
                    .name(discounts.getName())
                    .discountPercent(discounts.getDiscountPercent())
                    .desk(discounts.getDesk())
                    .createdAt(discounts.getCreatedAt())
                    .modifiedAt(discounts.getModifiedAt())
                    .build();

            discountDtos.add(discountDto);
        }

        return discountDtos;
    }


    @Override
    public void deleteById(Long id) {
        Discount discount = discountRepository.getDiscountById(id);
        if (discount == (null)) {
            throw new RuntimeException("bele id yoxdur");

        } else {
            discountRepository.deleteById(id);
        }
    }
}
