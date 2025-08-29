package com.example.order_service.order.domain.model;

public record OrderNumber(String orderNumber) {
    public OrderNumber {
        if (orderNumber == null || orderNumber.isBlank()) {
            throw new IllegalArgumentException("Order number cannot be null or empty");
        }

    }

    public static OrderNumber of(String orderNumber) {
        return new OrderNumber(orderNumber);
    }

}
