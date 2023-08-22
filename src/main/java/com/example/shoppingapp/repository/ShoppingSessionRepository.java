package com.example.shoppingapp.repository;

import com.example.shoppingapp.model.ShoppingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingSessionRepository extends JpaRepository<ShoppingSession, Long> {
    ShoppingSession getShoppingSessionById(Long id);
}
