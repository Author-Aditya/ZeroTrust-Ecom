package com.dailymart.store.serviceImpl;



import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dailymart.store.entity.Cart;
import com.dailymart.store.entity.CartItem;
import com.dailymart.store.entity.User;
import com.dailymart.store.repository.CartItemRepository;
import com.dailymart.store.repository.CartRepository;
import com.dailymart.store.repository.UserRepository;

@Service
public class CartService {

    private final CartRepository cartRepo;
    private final CartItemRepository itemRepo;
    private final UserRepository userRepo;

    public CartService(CartRepository cartRepo, CartItemRepository itemRepo, UserRepository userRepo) {
        this.cartRepo = cartRepo;
        this.itemRepo = itemRepo;
        this.userRepo = userRepo;
    }

    public Cart getCart(Long userId) {
        return cartRepo.findByUserId(userId)
                .orElseGet(() -> createCart(userId));
    }

    private Cart createCart(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setItems(new ArrayList<>());

        return cartRepo.save(cart);
    }

    public Cart addToCart(Long userId, Long productId, int quantity) {
        Cart cart = getCart(userId);

        Optional<CartItem> existingItem =
                itemRepo.findByCartIdAndProductId(cart.getId(), productId);

        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
            itemRepo.save(item);
        } else {
            CartItem item = new CartItem();
            item.setCart(cart);
            item.setProductId(productId);
            item.setQuantity(quantity);
            itemRepo.save(item);
        }

        return getCart(userId);
    }

    public Cart removeFromCart(Long userId, Long productId) {
        Cart cart = getCart(userId);

        CartItem item = itemRepo.findByCartIdAndProductId(cart.getId(), productId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        itemRepo.delete(item);

        return getCart(userId);
    }

    public void clearCart(Long userId) {
        Cart cart = getCart(userId);
        itemRepo.deleteByCartId(cart.getId());
    }
}