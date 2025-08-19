package com.example.product_service.product.insfructure.repository;

import com.example.product_service.product.domain.model.Product;
import com.example.product_service.product.domain.model.ProductId;
import com.example.product_service.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductJPARepository implements ProductRepository {
    @Override
    public Optional<Product> findById(ProductId id) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void delete(ProductId id) {

    }
}
