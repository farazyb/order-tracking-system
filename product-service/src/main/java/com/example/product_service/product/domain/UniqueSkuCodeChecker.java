package com.example.product_service.product.domain;

import com.example.product_service.product.domain.model.SkuCode;

public interface UniqueSkuCodeChecker {
    boolean isUnique(SkuCode SkuCode);
}
