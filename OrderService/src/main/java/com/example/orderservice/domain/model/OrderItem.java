package com.example.orderservice.domain.model;

import javax.persistence.Embeddable;

@Embeddable
public class OrderItem {
    private String name;
    private int quantity;

    public OrderItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    // Getters and setters
}
