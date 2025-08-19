package com.example.product_service.product.application.service;

import com.example.product_service.annotations.UseCase;
import com.example.product_service.product.application.command.CreateProductCommand;
import com.example.product_service.product.application.dtos.ProductDTO;
import com.example.product_service.product.domain.model.Money;
import com.example.product_service.product.domain.model.Product;
import com.example.product_service.product.domain.model.ProductId;
import com.example.product_service.product.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

@UseCase
public class ProductApplicationService {

    private final ProductRepository productRepository;

    public ProductApplicationService(@Qualifier("productJPARepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public ProductDTO createProduct(CreateProductCommand cmd) {
        Product product = new Product(
                ProductId.newId(),
                cmd.name(),
                Money.of(cmd.price(), "EUR"),
                cmd.stockQuantity(),
                true
        );

        productRepository.save(product);

        return ProductDTO.from(product);
    }

    public Optional<ProductDTO> getProduct(String id) {
        return productRepository.findById(ProductId.of(id))
                .map(ProductDTO::from);
    }

}
