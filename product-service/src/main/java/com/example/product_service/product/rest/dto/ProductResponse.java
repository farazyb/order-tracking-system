package com.example.product_service.product.rest.dto;

import java.math.BigDecimal;

public record ProductResponse(
        String id,
        String name,
        String description,
        double price
) {
    public static ProductResponse from(com.example.product_service.product.domain.model.Product product) {
        return new ProductResponse(
                product.getProductId().value(),
                product.getName(),
                product.getDescription(),
                product.getPrice().amount().doubleValue()
        );
    }

}