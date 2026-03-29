package com.ecommerce.models;


import java.util.List;
import java.util.Map;

import com.ecommerce.models.enums.ProductStatus;


public class ProductResponseDTO {

    private String id;
    private String name;
    private String description;

    private String brandName;
    private String categoryName;

    private ProductStatus status;

    private List<ProductVariantDTO> variants;

    private Map<String, String> attributes;

    // 🔹 Constructors
    public ProductResponseDTO() {}

    public ProductResponseDTO(String id, String name, String description,
                              String brandName, String categoryName,
                              ProductStatus status,
                              List<ProductVariantDTO> variants,
                              Map<String, String> attributes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brandName = brandName;
        this.categoryName = categoryName;
        this.status = status;
        this.variants = variants;
        this.attributes = attributes;
    }

    // 🔹 Getters & Setters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public List<ProductVariantDTO> getVariants() {
        return variants;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public void setVariants(List<ProductVariantDTO> variants) {
        this.variants = variants;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}