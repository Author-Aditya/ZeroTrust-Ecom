package com.ecom.product.entities;

import java.time.LocalDateTime;

public class ProductReview {

    private String id;
    private String userId;

    private int rating; // 1–5
    private String comment;

    private LocalDateTime createdAt;
}