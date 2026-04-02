package com.dailymart.store.dtos;


import java.util.List;

public class CartResponseDTO {

    private Long cartId;
    private List<CartItemDTO> items;

    public CartResponseDTO() {}

    public CartResponseDTO(Long cartId, List<CartItemDTO> items) {
        this.cartId = cartId;
        this.items = items;
    }

    public Long getCartId() {
        return cartId;
    }

    public List<CartItemDTO> getItems() {
        return items;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public void setItems(List<CartItemDTO> items) {
        this.items = items;
    }
}