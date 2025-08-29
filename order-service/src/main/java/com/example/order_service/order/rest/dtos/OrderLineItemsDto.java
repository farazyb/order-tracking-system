package com.example.order_service.order.rest.dtos;

import java.math.BigDecimal;

public record OrderLineItemsDto(String skuCode, Integer quantity, BigDecimal price) {

}
