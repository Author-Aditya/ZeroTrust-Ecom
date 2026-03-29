package com.ecommerce.models.enums;

public enum TransactionType {

    ADD,        // Stock added (restock, supplier)
    REMOVE,     // Stock reduced (order placed)
    RESERVE,    // Reserved for cart/order
    RELEASE,    // Released (cart expired / cancel)

    ADJUSTMENT  // Manual correction (admin fix)
}