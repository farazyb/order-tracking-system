package com.example.product_service.product.infrastructure.repository;

import com.example.product_service.product.domain.model.Money;
import com.example.product_service.product.domain.model.Product;
import com.example.product_service.product.domain.model.ProductId;
import com.example.product_service.product.domain.repository.ProductRepository;
import com.example.product_service.product.infrastructure.entity.ProductEntity;
import com.example.product_service.product.infrastructure.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductJPARepository implements ProductRepository {
    private final ProductJPARepositoryInterface productJPARepositoryInterface;

    public ProductJPARepository(ProductJPARepositoryInterface productJPARepositoryInterface) {
        this.productJPARepositoryInterface = productJPARepositoryInterface;
    }


    @Override
    public List<Product> findAll() {
        List<ProductEntity> productEntities = productJPARepositoryInterface.findAll();
        return productEntities.stream().map(new ProductMapper()::productEntityToProduct).toList();

    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = new ProductMapper().productToProductEntity(product);
        productJPARepositoryInterface.save(productEntity);
        return product;
    }

}
