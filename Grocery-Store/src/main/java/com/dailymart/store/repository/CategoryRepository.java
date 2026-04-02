package com.dailymart.store.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dailymart.store.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}