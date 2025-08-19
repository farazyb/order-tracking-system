package com.example.product_service.product.domain.model;

import com.example.product_service.product.domain.exceptions.NotEnoughStockException;
import lombok.Data;

@Data
public class Product {
    private String name;
    private String description;
    private String imageUrl;
    private int quantity;
    private ProductId productId;
    private Money price;
    private boolean active;

    public Product(ProductId productId, String name, Money price, int quantity, boolean active) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.active = active;
    }

    public void reduceStock(int quantity) {
        if (this.quantity < quantity) {
            throw new NotEnoughStockException("Not enough stock to reduce by " + quantity);
        }
        this.quantity -= quantity;
    }

    public void changePrice(Money newPrice) {
        if (newPrice == null) {
            throw new IllegalArgumentException("New price cannot be null");
        }
        this.price = newPrice;
    }
}
