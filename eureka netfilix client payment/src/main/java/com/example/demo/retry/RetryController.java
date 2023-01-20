package com.example.demo.retry;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*
    Create by Atiye Mousavi 
    Date: 1/16/2023
    Time: 10:25 AM
**/
@RestController
public class RetryController {

    Logger logger = LoggerFactory.getLogger(RetryController.class);
    RestTemplate restTemplate= new RestTemplate();

    @GetMapping("/getInvoice")
    @Retry(name = "getInvoiceRetry", fallbackMethod = "getInvoiceFallback")
    public String getInvoice() {
        logger.info("getInvoice() call starts here");
        ResponseEntity<String> entity= restTemplate.getForEntity("http://localhost:8080/invoice/rest/find/2", String.class);
        logger.info("Response :" + entity.getStatusCode());
        return entity.getBody();
    }

    public String getInvoiceFallback(Exception e) {
        logger.info("---RESPONSE FROM FALLBACK METHOD---");
        return "SERVICE IS DOWN, PLEASE TRY AFTER SOMETIME !!!";
    }
}