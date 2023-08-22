package com.example.shoppingapp.service;

import com.example.shoppingapp.dto.OrderItemsDto;
import com.example.shoppingapp.dto.request.OrderDetailsRequest;
import com.example.shoppingapp.dto.request.OrderItemsRequest;
import com.example.shoppingapp.dto.response.OrderItemsResponse;

import java.util.List;

public interface OrderItemsService {
    OrderItemsDto getOrderItemsById(Long id);

    void saveOrderItems(OrderItemsRequest orderItemsRequest);

    void updateOrderItems(OrderItemsRequest orderItemsRequest);

    List<OrderItemsDto> getAll();

    void deleteById(Long id);


}
