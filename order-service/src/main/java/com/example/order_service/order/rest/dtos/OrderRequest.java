package com.example.order_service.order.rest.dtos;

import java.util.List;

public record OrderRequest(List<OrderLineItemsDto> orderLineItemsDtos) {
}
