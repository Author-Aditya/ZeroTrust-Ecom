package com.dailymart.store.dtos;


public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private double price;
    private boolean available;
    private Long categoryId;

    public ProductDTO() {}

    public ProductDTO(Long id, String name, String description, double price, boolean available, Long categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}