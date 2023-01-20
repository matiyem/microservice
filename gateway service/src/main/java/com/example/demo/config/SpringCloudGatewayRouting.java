package com.example.demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    Create by Atiye Mousavi 
    Date: 1/16/2023
    Time: 3:25 PM
**/
@Configuration
public class SpringCloudGatewayRouting {

    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("paymentId", r->r.path("/payment/**").uri("http://localhost:8989")) //static routing
                .route("orderId", r->r.path("/order/**").uri("lb://CART-SERVICE")) //dynamic routing
                .build();
    }
}


