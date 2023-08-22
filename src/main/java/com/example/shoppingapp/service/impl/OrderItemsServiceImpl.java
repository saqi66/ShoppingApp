package com.example.shoppingapp.service.impl;

import com.example.shoppingapp.dto.OrderItemsDto;
import com.example.shoppingapp.dto.request.OrderItemsRequest;
import com.example.shoppingapp.model.OrderItems;
import com.example.shoppingapp.repository.OrderItemsRepository;
import com.example.shoppingapp.service.OrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemsServiceImpl implements OrderItemsService {
    private final OrderItemsRepository orderItemsRepository;

    @Override
    public OrderItemsDto getOrderItemsById(Long id) {
        OrderItems orderItems = orderItemsRepository.getOrderItemsById(id);
        return OrderItemsDto.builder()
                .createdAt(orderItems.getCreatedAt())
                .modifiedAt(orderItems.getModifiedAt())
                .build();
    }

    @Override
    public void saveOrderItems(OrderItemsRequest orderItemsRequest) {
        OrderItems orderItems = OrderItems.builder()
                .createdAt((Date) orderItemsRequest.getCreatedAt())
                .build();

        orderItemsRepository.save(orderItems);
    }

    @Override
    public void updateOrderItems(OrderItemsRequest orderItemsRequest) {
        OrderItems orderItems = OrderItems.builder()
                .id(orderItemsRequest.getOrderId())
                .modifiedAt((Date) orderItemsRequest.getModifiedAt())
                .build();
        orderItemsRepository.save(orderItems);
    }

    @Override
    public List<OrderItemsDto> getAll() {
        List<OrderItems> orderItems = orderItemsRepository.findAll();
        List<OrderItemsDto> orderItemsDtos = new ArrayList<>();

        for (OrderItems orderItems1 : orderItems) {
            OrderItemsDto orderItemsDto = OrderItemsDto.builder()
                    .createdAt(orderItems1.getCreatedAt())
                    .modifiedAt(orderItems1.getModifiedAt())
                    .build();

            orderItemsDtos.add(orderItemsDto);
        }
        return orderItemsDtos;
    }

    @Override
    public void deleteById(Long id) {
        OrderItems orderItems = orderItemsRepository.getOrderItemsById(id);
        if (orderItems == (null)) {
            throw new RuntimeException("bele id yoxdur");

        } else {
            orderItemsRepository.deleteById(id);
        }
    }
}