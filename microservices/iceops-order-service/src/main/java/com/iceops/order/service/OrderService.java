package com.iceops.order.service;

import com.iceops.order.client.UserClient;
import com.iceops.order.entity.Order;
import com.iceops.order.events.OrderCreatedEvent;
import com.iceops.order.publisher.OrderEventPublisher;
import com.iceops.order.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final UserClient userClient;
    private final OrderEventPublisher eventPublisher;

    public OrderService(OrderRepository repository,
                        UserClient userClient,
                        OrderEventPublisher eventPublisher) {
        this.repository = repository;
        this.userClient = userClient;
        this.eventPublisher = eventPublisher;
    }

    public List<Order> getOrders() {
        return repository.findAll();
    }

    public Order create(Order order) {

        // guardar orden en base de datos
        Order savedOrder = repository.save(order);

        // publicar evento en RabbitMQ
        OrderCreatedEvent event =
                new OrderCreatedEvent(savedOrder.getId(), savedOrder.getUserId());

        eventPublisher.publishOrderCreated(event);

        return savedOrder;
    }

    // llamada al USER SERVICE usando Feign + Retry + Timeout + Circuit Breaker
    @Retry(name = "userServiceRetry")
    @TimeLimiter(name = "userServiceTimeout")
    @CircuitBreaker(name = "userServiceBreaker", fallbackMethod = "getUserFallback")
    public Object getUser(Long userId) {
        return userClient.getUserById(userId);
    }

    // método fallback si el user-service falla
    public Object getUserFallback(Long userId, Throwable throwable) {
        return "User Service is currently unavailable";
    }

}
