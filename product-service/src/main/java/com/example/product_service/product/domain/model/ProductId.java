package com.example.product_service.product.domain.model;

import lombok.Data;

@Data
public class ProductId {

    private String value;
    public ProductId(String value) {
        this.value = value;
    }

    public static ProductId of(String value) {
        return new ProductId(value);
    }

    public static ProductId newId() {
        return new ProductId(java.util.UUID.randomUUID().toString());
    }


}
