package com.dailymart.store.controller;


import org.springframework.web.bind.annotation.*;

import com.dailymart.store.entity.Category;
import com.dailymart.store.serviceImpl.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return service.getAll();
    }
}