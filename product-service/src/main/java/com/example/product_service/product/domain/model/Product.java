package com.example.product_service.product.domain.model;

import com.example.product_service.product.domain.exceptions.NotEnoughStockException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private ProductId productId;
    private String name;
    private String description;
    private Money price;

    public Product(ProductId productId, String name, Money price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

}
