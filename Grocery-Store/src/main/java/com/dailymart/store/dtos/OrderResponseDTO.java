package com.dailymart.store.dtos;


import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDTO {

    private Long orderId;
    private double totalAmount;
    private String status;
    private LocalDateTime createdAt;
    private List<OrderItemDTO> items;

    public OrderResponseDTO() {}

    public OrderResponseDTO(Long orderId, double totalAmount, String status,
                            LocalDateTime createdAt, List<OrderItemDTO> items) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdAt = createdAt;
        this.items = items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}