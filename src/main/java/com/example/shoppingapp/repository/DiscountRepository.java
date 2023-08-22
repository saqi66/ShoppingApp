package com.example.shoppingapp.repository;

import com.example.shoppingapp.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    Discount getDiscountById(Long id);
}
