package com.ecommerce.models;

import java.math.BigDecimal;
import java.util.Map;

public class ProductVariantDTO {

    private String id;
    private String sku;

    private BigDecimal price;

    private int availableQuantity;

    private Map<String, String> attributes;

    // 🔹 Constructors
    public ProductVariantDTO() {}

    public ProductVariantDTO(String id, String sku, BigDecimal price,
                             int availableQuantity,
                             Map<String, String> attributes) {
        this.id = id;
        this.sku = sku;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.attributes = attributes;
    }

    // 🔹 Getters & Setters

    public String getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}