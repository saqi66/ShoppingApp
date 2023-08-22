package com.example.shoppingapp.repository;

import com.example.shoppingapp.model.CardItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardItemRepository extends JpaRepository<CardItem, Long> {
CardItem getCardItemById(Long id);
}
