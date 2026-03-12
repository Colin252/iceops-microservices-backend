package com.iceops.payment.controller;

import com.iceops.payment.entity.Payment;
import com.iceops.payment.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service){
        this.service=service;
    }

    @GetMapping
    public List<Payment> getPayments(){
        return service.getPayments();
    }

    @PostMapping
    public Payment create(@RequestBody Payment payment){
        return service.create(payment);
    }
}