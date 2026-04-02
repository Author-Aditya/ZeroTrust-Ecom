package com.dailymart.store.serviceImpl;




import java.util.List;

import org.springframework.stereotype.Service;

import com.dailymart.store.entity.Product;
import com.dailymart.store.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getByCategory(Long categoryId) {
        return repo.findByCategoryId(categoryId);
    }

    public Product getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}