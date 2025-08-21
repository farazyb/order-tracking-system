package com.example.product_service.product.application.dtos;

import com.example.product_service.product.domain.model.Product;

public record ProductDTO(
        String id,
        String name,
        double price,
        String description
) {
    public static ProductDTO from(Product product) {
        return new ProductDTO(
                product.getProductId().value(),
                product.getName(),
                product.getPrice().amount().doubleValue(),
                product.getDescription()

        );
    }
}
