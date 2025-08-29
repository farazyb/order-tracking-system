package com.example.order_service.order.insfracture.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "order")
@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderLineItemsEntity> orderLineItems;
}
