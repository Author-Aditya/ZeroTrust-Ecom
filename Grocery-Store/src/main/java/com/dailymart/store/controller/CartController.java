package com.dailymart.store.controller;

import org.springframework.web.bind.annotation.*;

import com.dailymart.store.entity.Cart;
import com.dailymart.store.serviceImpl.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Cart addToCart(@RequestParam Long userId,
                          @RequestParam Long productId,
                          @RequestParam int quantity) {
        return service.addToCart(userId, productId, quantity);
    }

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable Long userId) {
        return service.getCart(userId);
    }

    @DeleteMapping("/remove")
    public Cart removeItem(@RequestParam Long userId,
                           @RequestParam Long productId) {
        return service.removeFromCart(userId, productId);
    }

    @DeleteMapping("/clear/{userId}")
    public void clearCart(@PathVariable Long userId) {
        service.clearCart(userId);
    }
}