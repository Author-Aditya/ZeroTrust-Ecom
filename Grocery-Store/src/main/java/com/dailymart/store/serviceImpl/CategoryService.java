package com.dailymart.store.serviceImpl;


import org.springframework.stereotype.Service;

import com.dailymart.store.entity.Category;
import com.dailymart.store.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<Category> getAll() {
        return repo.findAll();
    }
}