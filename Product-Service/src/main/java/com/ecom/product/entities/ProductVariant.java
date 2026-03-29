package com.ecom.product.entities;

import java.util.Map;

import jakarta.persistence.*;

@Entity
@Table(name = "product_variants")
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String sku;

    // 🔹 Many variants belong to one product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // 🔹 Flexible attributes (size, color, etc.)
    @ElementCollection
    @CollectionTable(name = "variant_attributes", joinColumns = @JoinColumn(name = "variant_id"))
    @MapKeyColumn(name = "attribute_key")
    @Column(name = "attribute_value")
    private Map<String, String> attributes;

    @Column(name = "is_active")
    private boolean active = true;

    // 🔹 Constructors
    public ProductVariant() {}

    public ProductVariant(String sku) {
        this.sku = sku;
    }

    // 🔹 Getters & Setters

    public String getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}