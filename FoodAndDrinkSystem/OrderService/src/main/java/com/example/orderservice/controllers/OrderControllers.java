/*
 * @ (#) OrderControllers.java     1.0     5/22/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.orderservice.controllers;

import com.example.orderservice.models.Order;
import com.example.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 2:46 AM 5/22/2024
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/v1/orders")
public class OrderControllers {

    @Autowired
    private OrderService orderService;


    // Áp dụng Agile-Scrum
    @GetMapping("/start-sprint")
    public String startSprint() {
        orderService.planSprint();
        orderService.executeSprint();
        return "Sprint started and executed";
    }


    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getListOrder();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }






}
