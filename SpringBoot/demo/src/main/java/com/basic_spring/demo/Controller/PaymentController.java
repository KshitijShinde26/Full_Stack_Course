package com.basic_spring.demo.Controller;




import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic_spring.demo.Service.PaymentGateway;

@RestController
public class PaymentController {

    private final PaymentGateway paymentGateway;

    public PaymentController(
            @Qualifier("razorpayService") PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @GetMapping("/pay")
    public String pay() {
        return paymentGateway.pay();
    }
}
