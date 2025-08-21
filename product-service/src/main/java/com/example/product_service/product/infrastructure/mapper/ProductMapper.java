package com.example.product_service.product.infrastructure.mapper;

import com.example.product_service.product.domain.model.Money;
import com.example.product_service.product.domain.model.Product;
import com.example.product_service.product.domain.model.ProductId;
import com.example.product_service.product.infrastructure.entity.ProductEntity;

public class ProductMapper {
    public Product productEntityToProduct(ProductEntity productEntity) {
        return Product.builder()
                .productId(ProductId.of(productEntity.getId()))
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(Money.of(productEntity.getPrice(), "EURO")).build();
    }

    public ProductEntity productToProductEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getProductId().value())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice().amount())
                .build();
    }
}
