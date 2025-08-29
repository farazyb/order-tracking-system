package com.example.product_service.product.domain.exceptions;

import com.example.product_service.product.domain.model.SkuCode;

public class DuplicateSkuCode extends RuntimeException {
    public DuplicateSkuCode(SkuCode skuCode) {
        super("Product with SKU code " + skuCode.code() + " already exists");

    }
}
