package com.example.product_service.product.infrastructure.repository;

import com.example.product_service.product.infrastructure.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJPARepositoryInterface extends MongoRepository<ProductEntity, String> {
}
