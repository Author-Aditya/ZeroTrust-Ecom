package com.dailymart.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailymart.store.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long categoryId);

    List<Product> findByAvailableTrue();
}