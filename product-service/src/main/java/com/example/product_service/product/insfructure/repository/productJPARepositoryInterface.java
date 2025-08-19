package com.example.product_service.product.insfructure.repository;

import com.example.product_service.product.insfructure.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productJPARepositoryInterface extends CrudRepository<Product, String> {
}
