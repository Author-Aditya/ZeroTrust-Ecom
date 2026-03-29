package com.ecommerce.models;

import java.math.BigDecimal;
import java.util.Map;


public class ProductVariantRequestDTO {

   
    private String sku;

   
    private BigDecimal price;

    
    private Integer quantity;

    private Map<String, String> attributes;

    // 🔹 Getters & Setters

    public String getSku() {
        return sku;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}