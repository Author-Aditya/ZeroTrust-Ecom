package com.ecom.product.models;

import java.time.LocalDateTime;

public class Audit {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String createdBy;
    private String updatedBy;
}