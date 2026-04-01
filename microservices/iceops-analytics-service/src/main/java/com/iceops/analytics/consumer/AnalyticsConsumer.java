package com.iceops.analytics.consumer;

import com.iceops.analytics.entity.EventData;
import com.iceops.analytics.repository.EventDataRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AnalyticsConsumer {

    private final EventDataRepository repository;

    public AnalyticsConsumer(EventDataRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = "analytics.queue")
    public void receiveMessage(String message) {
        EventData event = new EventData();
        event.setEventType("RABBITMQ_EVENT");
        event.setPayload(message);
        event.setCreatedAt(LocalDateTime.now());
        repository.save(event);
        System.out.println("Saved event: " + message);
    }
}