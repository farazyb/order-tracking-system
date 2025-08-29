package com.example.product_service.product.domain.model;

public record SkuCode(String code) {
    public SkuCode {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("SKU code cannot be null or empty");
        }
    }

    public static SkuCode of(String code) {
        return new SkuCode(code);
    }
}
