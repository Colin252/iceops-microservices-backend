package com.iceops.analytics.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String ANALYTICS_QUEUE = "analytics.queue";

    @Bean
    public Queue analyticsQueue() {
        return new Queue(ANALYTICS_QUEUE, true); // durable = true
    }
}