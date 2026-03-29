package com.ecom.product.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InventoryLocation implements Serializable {

    @Column(name = "warehouse_id", nullable = false)
    private String warehouseId;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "reserved_quantity", nullable = false)
    private int reservedQuantity;

    //  Constructors
    public InventoryLocation() {}

    public InventoryLocation(String warehouseId, int quantity, int reservedQuantity) {
        this.warehouseId = warehouseId;
        this.quantity = quantity;
        this.reservedQuantity = reservedQuantity;
    }

    //  Business helper
    public int getAvailableQuantity() {
        return quantity - reservedQuantity;
    }

    //  Getters

    public String getWarehouseId() {
        return warehouseId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getReservedQuantity() {
        return reservedQuantity;
    }

    //  Setters (optional — can remove for immutability)

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setReservedQuantity(int reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    // 🔹 equals & hashCode (VERY IMPORTANT for Value Objects)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventoryLocation)) return false;
        InventoryLocation that = (InventoryLocation) o;
        return Objects.equals(warehouseId, that.warehouseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warehouseId);
    }
}