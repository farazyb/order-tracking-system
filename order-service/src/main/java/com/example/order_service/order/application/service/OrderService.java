package com.example.order_service.order.application.service;

import com.example.order_service.order.application.OrderServiceInterface;
import com.example.order_service.order.domain.model.Order;
import com.example.order_service.order.domain.model.OrderLineItems;
import com.example.order_service.order.domain.model.OrderNumber;
import com.example.order_service.order.domain.model.SkuCode;
import com.example.order_service.order.rest.dtos.OrderLineItemsDto;
import com.example.order_service.order.rest.dtos.OrderRequest;

import java.util.List;
import java.util.UUID;

public class OrderService implements OrderServiceInterface {
    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(OrderNumber.of(UUID.randomUUID().toString()));
        List<OrderLineItems> list = orderRequest.orderLineItemsDtos().stream()
                .map(this::mapDTOToOrderLineItem).toList();
        order.setOrderLineItemsList(list);
    }

    private OrderLineItems mapDTOToOrderLineItem(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.price());
        orderLineItems.setQuantity(orderLineItemsDto.quantity());
        orderLineItems.setSkuCode(new SkuCode(orderLineItemsDto.skuCode()));
        return orderLineItems;
    }
}
