package com.example.order_service.order.domain.model;

public record SkuCode(String code) {
    public SkuCode {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("SKU code cannot be null or empty");
        }
    }
}
