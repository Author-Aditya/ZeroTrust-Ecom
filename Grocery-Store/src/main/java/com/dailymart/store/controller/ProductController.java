package com.dailymart.store.controller;



import org.springframework.web.bind.annotation.*;

import com.dailymart.store.entity.Product;
import com.dailymart.store.serviceImpl.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getByCategory(@PathVariable Long categoryId) {
        return service.getByCategory(categoryId);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.getById(id);
    }
}