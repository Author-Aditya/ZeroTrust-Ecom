package com.ecom.product.entities;

import java.util.List;

import com.ecom.product.embeddable.InventoryLocation;
import com.ecom.product.enums.InventoryStatus;
import com.ecom.product.models.Audit;

import jakarta.persistence.*;

@Entity
@Table(name = "inventories")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "product_variant_id", nullable = false, unique = true)
    private String productVariantId;

    @Column(name = "total_quantity", nullable = false)
    private int totalQuantity;

    @Column(name = "reserved_quantity", nullable = false)
    private int reservedQuantity;

    @Column(name = "available_quantity", nullable = false)
    private int availableQuantity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InventoryStatus status;

    //  InventoryLocation as Value Object
    @ElementCollection
    @CollectionTable(name = "inventory_locations", joinColumns = @JoinColumn(name = "inventory_id"))
    private List<InventoryLocation> locations;

    //  Embedded Audit
    @Embedded
    private Audit audit;

    //  Lifecycle hooks
    @PrePersist
    @PreUpdate
    private void calculateAvailableQuantity() {
        this.availableQuantity = this.totalQuantity - this.reservedQuantity;
    }

    //  Constructors
    public Inventory() {}

    public Inventory(String productVariantId, int totalQuantity) {
        this.productVariantId = productVariantId;
        this.totalQuantity = totalQuantity;
        this.reservedQuantity = 0;
    }

    //  Getters & Setters

    public String getId() {
        return id;
    }

    public String getProductVariantId() {
        return productVariantId;
    }

    public void setProductVariantId(String productVariantId) {
        this.productVariantId = productVariantId;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getReservedQuantity() {
        return reservedQuantity;
    }

    public void setReservedQuantity(int reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public InventoryStatus getStatus() {
        return status;
    }

    public void setStatus(InventoryStatus status) {
        this.status = status;
    }

    public List<InventoryLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<InventoryLocation> locations) {
        this.locations = locations;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }
}