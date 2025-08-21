package com.example.product_service.product.application;

import com.example.product_service.product.rest.dto.ProductCreateRequest;
import com.example.product_service.product.rest.dto.ProductResponse;

import java.util.List;

public interface ProductApplicationServiceInterface {

    void createProduct(ProductCreateRequest createRequest);


    List<ProductResponse> getAllProducts();

}