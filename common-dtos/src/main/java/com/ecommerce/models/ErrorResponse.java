package com.ecommerce.models;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String message;
    private String details;
    private LocalDateTime timestamp;

    public ErrorResponse(String message, String details, LocalDateTime timestamp) {
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}