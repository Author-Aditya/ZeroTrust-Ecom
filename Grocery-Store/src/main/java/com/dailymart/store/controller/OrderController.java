package com.dailymart.store.controller;


import org.springframework.web.bind.annotation.*;

import com.dailymart.store.entity.Order;
import com.dailymart.store.serviceImpl.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/place")
    public Order placeOrder(@RequestParam Long userId) {
        return service.placeOrder(userId);
    }

    @GetMapping("/{userId}")
    public List<Order> getUserOrders(@PathVariable Long userId) {
        return service.getOrders(userId);
    }
}