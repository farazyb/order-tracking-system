package com.example.order_service.order.rest;

import com.example.order_service.order.rest.dtos.OrderRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/order")
class OrderController {
    @PostMapping
    public String placeOrder(OrderRequest request) {
        return "Order placed successfully";
    }

}
