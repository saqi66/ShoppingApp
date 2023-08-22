package com.example.shoppingapp.controller;

import com.example.shoppingapp.dto.DiscountDto;
import com.example.shoppingapp.dto.request.DiscountRequest;
import com.example.shoppingapp.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/discount")
public class DiscountController {

    final DiscountService discountService;

    @GetMapping(value = "/discountList")
    public List<DiscountDto> getDiscountInfo() {
        return discountService.getAll();
    }

    @GetMapping(value = "/getDiscountById/{id}")
    public DiscountDto getDiscountById(@PathVariable(value = "id") Long id) {
        return discountService.getDiscountById(id);
    }

    @PostMapping(value = "/saveDiscount")
    public void saveDiscount(@RequestBody DiscountRequest discountRequest) {
        discountService.saveDiscount(discountRequest);
    }

    @PostMapping(value = "/updateDiscount")
    public void updateDiscount(@RequestBody DiscountRequest discountRequest) {
        discountService.updateDiscount(discountRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        discountService.deleteById(id);
    }

}

