package com.example.product_service.product.application.command;

public record CreateProductCommand(
        String name,
        double price,
        int stockQuantity
) {
}
