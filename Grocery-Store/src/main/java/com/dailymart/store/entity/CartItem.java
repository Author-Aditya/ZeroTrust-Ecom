package com.dailymart.store.entity;

import jakarta.persistence.*;

@Entity
@Table(
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cart_id", "product_id"})
    }
)
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    public CartItem() {}

    public CartItem(Long id, int quantity, Cart cart, Long productId) {
        this.id = id;
        this.quantity = quantity;
        this.cart = cart;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public Long getProductId() {
        return productId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
