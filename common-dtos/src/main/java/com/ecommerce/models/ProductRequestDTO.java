package com.ecommerce.models;


import java.util.List;
import java.util.Map;


public class ProductRequestDTO {

   
    private String name;

    private String description;

   
    private String brandId;

   
    private String categoryId;

    private List<ProductVariantRequestDTO> variants;

    private Map<String, String> attributes;

    // 🔹 Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getBrandId() {
        return brandId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public List<ProductVariantRequestDTO> getVariants() {
        return variants;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setVariants(List<ProductVariantRequestDTO> variants) {
        this.variants = variants;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}