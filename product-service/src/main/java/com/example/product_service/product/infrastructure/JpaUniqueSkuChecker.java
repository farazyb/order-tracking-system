package com.example.product_service.product.infrastructure;

import com.example.product_service.product.domain.UniqueSkuCodeChecker;
import com.example.product_service.product.domain.model.SkuCode;
import com.example.product_service.product.infrastructure.repository.ProductJPARepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaUniqueSkuChecker implements UniqueSkuCodeChecker {
    @Autowired
    ProductJPARepositoryInterface productJPARepositoryInterface;

    @Override
    public boolean isUnique(SkuCode SkuCode) {

        return productJPARepositoryInterface.findBySkuCode(SkuCode.code()).isEmpty();
    }
}
