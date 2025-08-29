package com.example.product_service.product.application.service;

import com.example.product_service.annotations.UseCase;
import com.example.product_service.product.application.ProductApplicationServiceInterface;
import com.example.product_service.product.domain.UniqueSkuCodeChecker;
import com.example.product_service.product.domain.model.Money;
import com.example.product_service.product.domain.model.Product;
import com.example.product_service.product.domain.model.ProductId;
import com.example.product_service.product.domain.model.SkuCode;
import com.example.product_service.product.domain.repository.ProductRepository;
import com.example.product_service.product.rest.dto.ProductCreateRequest;
import com.example.product_service.product.rest.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Qualifier;

import java.math.BigDecimal;
import java.util.List;

@UseCase
public class ProductApplicationService implements ProductApplicationServiceInterface {

    private final ProductRepository productRepository;
    private final UniqueSkuCodeChecker uniqueSkuCodeChecker;

    public ProductApplicationService(ProductRepository productRepository, @Qualifier("jpaUniqueSkuChecker") UniqueSkuCodeChecker uniqueSkuCodeChecker) {
        this.productRepository = productRepository;
        this.uniqueSkuCodeChecker = uniqueSkuCodeChecker;
    }


    @Override
    public void createProduct(ProductCreateRequest createRequest) {
        Product product = Product.create(new ProductId(), createRequest.name()
                , Money.of(createRequest.price(), "EURO"),
                SkuCode.of(createRequest.skuCode()), createRequest.description(), uniqueSkuCodeChecker);

        productRepository.save(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductResponse::from).toList();
    }
}
