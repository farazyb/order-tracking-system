package com.example.order_service.order.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineItems {
    private BigDecimal price;
    private SkuCode skuCode;
    private Integer quantity;

}
