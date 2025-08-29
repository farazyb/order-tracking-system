package com.example.product_service.product.domain.repository;

import com.example.product_service.product.domain.model.Product;
import com.example.product_service.product.domain.model.ProductId;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();

    Product save(Product product);


}
