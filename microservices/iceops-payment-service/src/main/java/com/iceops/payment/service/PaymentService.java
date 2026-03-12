package com.iceops.payment.service;

import com.iceops.payment.entity.Payment;
import com.iceops.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository){
        this.repository=repository;
    }

    public List<Payment> getPayments(){
        return repository.findAll();
    }

    public Payment create(Payment payment){
        return repository.save(payment);
    }
}