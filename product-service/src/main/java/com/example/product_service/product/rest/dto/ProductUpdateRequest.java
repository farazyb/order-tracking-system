package com.example.product_service.product.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public record ProductUpdateRequest(
    @NotBlank(message = "Product name cannot be blank.")
    String name,
    String description,
    @NotNull(message = "Product price cannot be null.")
    @Positive(message = "Product price must be positive.")
    BigDecimal price,
    @NotNull(message = "Quantity in stock cannot be null.")
    @PositiveOrZero(message = "Quantity in stock cannot be negative.")
    Integer quantityInStock
) {}