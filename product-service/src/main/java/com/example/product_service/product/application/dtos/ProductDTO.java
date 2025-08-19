package com.example.product_service.product.application.dtos;

import com.example.product_service.product.domain.model.Product;

public record ProductDTO(
        String id,
        String name,
        double price,
        int stockQuantity,
        boolean active
) {
    public static ProductDTO from(Product product) {
        return new ProductDTO(
                product.getProductId().getValue(),
                product.getName(),
                product.getPrice().getValue(),
                product.getQuantity(),
                product.isActive()
        );
    }
}
