package com.example.shoppingapp.repository;

import com.example.shoppingapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users getUsersById(Long id);
}
