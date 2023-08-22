package com.example.shoppingapp.repository;

import com.example.shoppingapp.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {

    OrderItems getOrderItemsById(Long id);

}
