package com.example.product_service.product.rest;

import com.example.product_service.product.application.ProductApplicationServiceInterface;
import com.example.product_service.product.rest.dto.ProductCreateRequest;
import com.example.product_service.product.rest.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
class ProductController {

    private final ProductApplicationServiceInterface productApplicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductCreateRequest productRequest) {
        productApplicationService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productApplicationService.getAllProducts();
    }
}
