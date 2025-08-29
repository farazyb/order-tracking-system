package com.example.order_service.order.insfracture.repository;

import com.example.order_service.order.domain.model.Order;
import com.example.order_service.order.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class JpaOrderRepository implements OrderRepository {
    private final JpaOrderRepositoryInterface jpaOrderRepositoryInterface;

    public JpaOrderRepository(JpaOrderRepositoryInterface jpaOrderRepositoryInterface) {
        this.jpaOrderRepositoryInterface = jpaOrderRepositoryInterface;
    }
    @Override
    public void save(Order order) {


    }
}
