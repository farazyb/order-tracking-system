package com.example.product_service.product.rest.dto;

import com.example.product_service.product.domain.model.SkuCode;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.validation.constraints.*;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record ProductCreateRequest(
        @NotBlank(message = "Product name cannot be blank.")
        String name,

        String description,

        @NotNull(message = "Product price cannot be null.")
        @DecimalMin(value = "0.0", inclusive = false, message = "Product price must be positive.")
        @Digits(integer = 10, fraction = 2, message = "Product price has an invalid format.")
        BigDecimal price,
        @NotBlank(message = "SKU code cannot be blank.")
        String skuCode
) {
}