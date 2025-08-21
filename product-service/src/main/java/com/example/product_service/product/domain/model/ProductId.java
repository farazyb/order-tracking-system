package com.example.product_service.product.domain.model;


public record ProductId(String value) {
    public ProductId {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
    }

    public ProductId() {
        this(java.util.UUID.randomUUID().toString());
    }

    public static ProductId of(String value) {
        return new ProductId(value);
    }
}
