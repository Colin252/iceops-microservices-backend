package com.iceops.order.controller;

import com.iceops.order.entity.Order;
import com.iceops.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Order> getOrders() {
        return service.getOrders();
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }

    // endpoint para probar comunicación con USER SERVICE
    @GetMapping("/user/{id}")
    public Object getUser(@PathVariable Long id) {
        return service.getUser(id);
    }
}