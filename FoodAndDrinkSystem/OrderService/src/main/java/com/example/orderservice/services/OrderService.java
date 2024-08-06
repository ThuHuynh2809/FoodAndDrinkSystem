/*
 * @ (#) OrderService.java     1.0     5/22/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.orderservice.services;

import com.example.orderservice.models.Order;
import com.example.orderservice.models.User;
import com.example.orderservice.repositories.OrderRepository;
import com.example.orderservice.scrum.ProductBacklog;
import com.example.orderservice.scrum.SprintBacklog;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.List;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 2:43 AM 5/22/2024
 * @version: 1.0
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;
    private final ProductBacklog productBacklog = new ProductBacklog();
    private final SprintBacklog sprintBacklog = new SprintBacklog();


    // Áp dụng Agile-Scrum
    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
        // Giả sử thêm một số mục vào Product Backlog
        productBacklog.addItem("Create new order");
        productBacklog.addItem("Update order");
        productBacklog.addItem("Delete order");
        productBacklog.addItem("Get all orders");
        productBacklog.addItem("Get order by ID");
    }

    public void planSprint() {
        // Lấy các mục tiêu từ Product Backlog cho Sprint đầu tiên
        sprintBacklog.addItem(productBacklog.getItems().get(0)); // Create new order
        sprintBacklog.addItem(productBacklog.getItems().get(1)); // Update order
        sprintBacklog.addItem(productBacklog.getItems().get(2)); // Delete order
    }

    public void executeSprint() {
        // Thực hiện các mục tiêu trong Sprint
        Iterator<String> iterator = sprintBacklog.getItems().iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println("Executing: " + item);
            // Giả lập hoàn thành công việc
            iterator.remove();
        }
    }

    public List<Order> getListOrder(){
        List<Order> orderList = orderRepository.findAll();
        for (Order o: orderList) {
            User user = restTemplate.getForObject("http://localhost:8082/api/users/"+o.getId(), User.class);
            o.setUser(user);
        }
        return orderList;
    }

    public Order getOrderById(long id){
        Order order = orderRepository.findById(id).get();
        User user = restTemplate.getForObject("http://localhost:8082/api/users/"+id, User.class);
        order.setUser(user);
        return order;
    }

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrderById(long id){
        orderRepository.deleteById(id);
    }
}
