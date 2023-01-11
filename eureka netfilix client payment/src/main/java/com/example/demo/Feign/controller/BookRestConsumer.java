package com.example.demo.Feign.controller;

import com.example.demo.Feign.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 1/11/2023
    Time: 10:30 AM
**/
@FeignClient(name="CART-SERVICE")
public interface BookRestConsumer {

    @GetMapping("/book/data")
    public String getBookData();

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Integer id);

    @GetMapping("/book/all")
    public List<Book> getAllBooks();

    @GetMapping("/book/entity")
    public ResponseEntity<String> getEntityData();
}