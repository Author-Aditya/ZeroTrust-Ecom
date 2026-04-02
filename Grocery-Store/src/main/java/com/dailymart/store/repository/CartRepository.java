package com.dailymart.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailymart.store.entity.Cart;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByUserId(Long userId);
}