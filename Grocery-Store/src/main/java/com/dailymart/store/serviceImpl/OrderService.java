package com.dailymart.store.serviceImpl;


import org.springframework.stereotype.Service;

import com.dailymart.store.entity.Cart;
import com.dailymart.store.entity.CartItem;
import com.dailymart.store.entity.Order;
import com.dailymart.store.entity.OrderItem;
import com.dailymart.store.entity.Product;
import com.dailymart.store.entity.User;
import com.dailymart.store.enums.OrderStatus;
import com.dailymart.store.repository.CartItemRepository;
import com.dailymart.store.repository.CartRepository;
import com.dailymart.store.repository.OrderRepository;
import com.dailymart.store.repository.ProductRepository;
import com.dailymart.store.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final CartRepository cartRepo;
    private final CartItemRepository itemRepo;
    private final OrderRepository orderRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;

    public OrderService(CartRepository cartRepo,
                        CartItemRepository itemRepo,
                        OrderRepository orderRepo,
                        UserRepository userRepo,
                        ProductRepository productRepo) {
        this.cartRepo = cartRepo;
        this.itemRepo = itemRepo;
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
    }

    public Order placeOrder(Long userId) {

        Cart cart = cartRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        List<CartItem> cartItems = cart.getItems();

        if (cartItems == null || cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order();
        order.setUser(user);
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(OrderStatus.CREATED);

        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;

        for (CartItem cartItem : cartItems) {

            Product product = productRepo.findById(cartItem.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProductId(product.getId());
            item.setProductName(product.getName());
            item.setPrice(product.getPrice());
            item.setQuantity(cartItem.getQuantity());

            total += product.getPrice() * cartItem.getQuantity();

            orderItems.add(item);
        }

        order.setItems(orderItems);
        order.setTotalAmount(total);

        Order savedOrder = orderRepo.save(order);

        itemRepo.deleteByCartId(cart.getId());

        return savedOrder;
    }

    public List<Order> getOrders(Long userId) {
        return orderRepo.findByUserId(userId);
    }
}