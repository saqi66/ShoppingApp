package com.example.shoppingapp.service;

import com.example.shoppingapp.dto.OrderDetailsDto;
import com.example.shoppingapp.dto.request.OrderDetailsRequest;

import java.util.List;

public interface OrderDetailsService {

    OrderDetailsDto getOrderDetailsById(Long id);

    void saveOrderDetails(OrderDetailsRequest orderDetailsRequest);
    void updateOrderDetails(OrderDetailsRequest orderDetailsRequest);

    List<OrderDetailsDto>getAll();

    void deleteById(Long id);


}
