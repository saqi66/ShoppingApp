package com.example.shoppingapp.service.impl;

import com.example.shoppingapp.dto.OrderDetailsDto;
import com.example.shoppingapp.dto.request.OrderDetailsRequest;
import com.example.shoppingapp.model.OrderDetails;
import com.example.shoppingapp.repository.OrderDetailsRepository;
import com.example.shoppingapp.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    @Override
    public OrderDetailsDto getOrderDetailsById(Long id) {
        OrderDetails orderDetails = orderDetailsRepository.getOrderDetailsById(id);
        return OrderDetailsDto.builder()
                .total(orderDetails.getTotal())
                .createdAt(orderDetails.getCreatedAt())
                .modifiedAt(orderDetails.getModifiedAt())
                .build();
    }

    @Override
    public void saveOrderDetails(OrderDetailsRequest orderDetailsRequest) {
        OrderDetails orderDetails = OrderDetails.builder()
                .total(orderDetailsRequest.getTotal())
                .createdAt(orderDetailsRequest.getCreatedAt())
                .build();

        orderDetailsRepository.save(orderDetails);
    }

    @Override
    public void updateOrderDetails(OrderDetailsRequest orderDetailsRequest) {
        OrderDetails orderDetails = OrderDetails.builder()
                .id(orderDetailsRequest.getId())
                .total(orderDetailsRequest.getTotal())
                .modifiedAt(orderDetailsRequest.getModifiedAt())
                .build();

        orderDetailsRepository.save(orderDetails);

    }

    @Override
    public List<OrderDetailsDto> getAll() {
        List<OrderDetails> orderDetails = orderDetailsRepository.findAll();
        List<OrderDetailsDto> orderDetailsDtos = new ArrayList<>();

        for (OrderDetails orderDetails1 : orderDetails) {
            OrderDetailsDto orderDetailsDto = OrderDetailsDto.builder()
                    .total(orderDetails1.getTotal())
                    .createdAt(orderDetails1.getCreatedAt())
                    .modifiedAt(orderDetails1.getModifiedAt())
                    .build();

            orderDetailsDtos.add(orderDetailsDto);
        }
        return orderDetailsDtos;
    }
    @Override
    public void deleteById(Long id) {
        OrderDetails orderDetails = orderDetailsRepository.getOrderDetailsById(id);
        if (orderDetails == (null)) {
            throw new RuntimeException("bele id yoxdur");

        } else {
            orderDetailsRepository.deleteById(id);
        }
    }
}
