package com.basic_spring.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class StripeService implements PaymentGateway {

    @Override
    public String pay() {
        return "Payment done using Stripe";
    }
}
