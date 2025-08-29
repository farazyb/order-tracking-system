package com.example.product_service.product.domain.model;

import com.example.product_service.product.domain.UniqueSkuCodeChecker;
import com.example.product_service.product.domain.exceptions.DuplicateSkuCode;
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
    private SkuCode skuCode;

    private Product(ProductId productId, String name, Money price, SkuCode skuCode,String description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.skuCode = skuCode;
        this.description = description;

    }

    public static Product create(ProductId productId, String name, Money price,
                                 SkuCode skuCode,String description, UniqueSkuCodeChecker checker) {
        if (!checker.isUnique(skuCode)) {
            throw new DuplicateSkuCode(skuCode);
        }
        return new Product(productId, name, price, skuCode,description);
    }
}
