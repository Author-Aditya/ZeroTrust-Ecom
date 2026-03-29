package com.ecom.product.embeddable;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.ecom.product.enums.AdjustmentType;

@Embeddable
public class PriceAdjustment implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private AdjustmentType type; 
    // DISCOUNT, TAX, COUPON

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(length = 255)
    private String description;

    // Constructors
    public PriceAdjustment() {}

    public PriceAdjustment(AdjustmentType type, BigDecimal amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    //  Getters

    public AdjustmentType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    //  Setters (optional for immutability)

    public void setType(AdjustmentType type) {
        this.type = type;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //  equals & hashCode (important for collections)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceAdjustment)) return false;
        PriceAdjustment that = (PriceAdjustment) o;
        return type == that.type &&
               Objects.equals(amount, that.amount) &&
               Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, amount, description);
    }
}