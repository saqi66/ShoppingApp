package com.example.shoppingapp.service;

import com.example.shoppingapp.dto.DiscountDto;
import com.example.shoppingapp.dto.request.DiscountRequest;

import java.util.List;

public interface DiscountService {

    DiscountDto getDiscountById(Long id);

    void saveDiscount(DiscountRequest discountRequest);

    void updateDiscount(DiscountRequest discountRequest);

    List<DiscountDto>getAll();

    void deleteById(Long id);

}
