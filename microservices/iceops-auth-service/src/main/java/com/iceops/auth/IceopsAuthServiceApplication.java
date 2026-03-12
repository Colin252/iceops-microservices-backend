package com.iceops.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class IceopsAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IceopsAuthServiceApplication.class, args);
    }

}