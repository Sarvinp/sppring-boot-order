package com.example.orderservice.interfaceweb.web;

import com.example.orderservice.application.OrderService;
import com.example.orderservice.domain.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> createOrder() {
        Order order = new Order();
        service.placeOrder(order);
        return ResponseEntity.ok("Order created with ID: " + order.getId());
    }

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Order service is running!");
    }

}
