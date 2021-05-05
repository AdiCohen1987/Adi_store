package com.adi.services.interfaces;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    void pay(String paymentMethod, double price, int quantity);
}
