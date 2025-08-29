package com.example.order_service.order.application;

import com.example.order_service.order.rest.dtos.OrderRequest;

public interface OrderServiceInterface {
    void placeOrder(OrderRequest orderRequest   );
}
