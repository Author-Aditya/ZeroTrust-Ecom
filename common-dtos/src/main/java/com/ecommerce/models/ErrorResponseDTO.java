package com.ecommerce.models;

import java.time.LocalDateTime;

public class ErrorResponseDTO {

    private String message;
    private String details;
    private LocalDateTime timestamp;

    public ErrorResponseDTO(String message, String details, LocalDateTime timestamp) {
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