package com.example.product_service.product.domain.repository;

import com.example.product_service.product.domain.model.Product;
import com.example.product_service.product.domain.model.ProductId;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(ProductId id);

    Product save(Product product);

    void delete(ProductId id);
}
