package com.ecom.product.models;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductPrice {
    private BigDecimal basePrice;
    private String currency;
}