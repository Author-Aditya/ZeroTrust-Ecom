package com.ecom.product.entities;

import java.time.LocalDateTime;

import com.ecom.product.enums.TransactionType;
import com.ecom.product.models.Audit;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory_transactions")
public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "product_variant_id", nullable = false)
    private String productVariantId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "reference_id")
    private String referenceId; 
    // orderId / cartId / adminActionId

    @Column(name = "reference_type")
    private String referenceType; 
    // ORDER, CART, ADMIN

    @Column(name = "warehouse_id")
    private String warehouseId;

    @Column(length = 255)
    private String reason;

    // Embedded Audit
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "createdAt", column = @Column(name = "audit_created_at")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "audit_updated_at"))
    })
    private Audit audit;

    // Optional: quick timestamp (useful for sorting without digging into audit)
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // 🔹 Lifecycle hook
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Constructors
    public InventoryTransaction() {}

    public InventoryTransaction(String productVariantId, TransactionType type, int quantity) {
        this.productVariantId = productVariantId;
        this.type = type;
        this.quantity = quantity;
    }

    // 🔹 Getters & Setters

    public String getId() {
        return id;
    }

    public String getProductVariantId() {
        return productVariantId;
    }

    public void setProductVariantId(String productVariantId) {
        this.productVariantId = productVariantId;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}