package com.example.order_service.order.domain.repository;

import com.example.order_service.order.domain.model.Order;

public interface OrderRepository {
    void save(Order order);


}
