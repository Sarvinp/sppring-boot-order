package com.example.orderservice.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.ElementCollection;
import javax.persistence.Table;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ElementCollection
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
        this.id = UUID.randomUUID();
        this.status = OrderStatus.CREATED;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void complete() {
        this.status = OrderStatus.COMPLETED;
    }

    public UUID getId() {
        return id;
    }

}
