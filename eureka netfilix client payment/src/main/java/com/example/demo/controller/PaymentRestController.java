package com.example.demo.controller;

import com.example.demo.config.CartRestConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Create by Atiye Mousavi 
    Date: 1/10/2023
    Time: 9:36 AM
**/
@RestController
@RequestMapping("/payment")
public class PaymentRestController {

    @Autowired
    private CartRestConsumer consumer;  // HAS-A

    @GetMapping("/data")
    public String getPaymentData() {
        return "FROM PAYMENT-SERVICE : " + consumer.getCartInfo();
    }
}