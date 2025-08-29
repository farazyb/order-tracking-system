package com.example.order_service.order.insfracture.repository;

import com.example.order_service.order.insfracture.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepositoryInterface extends JpaRepository<OrderEntity, Long> {
}
