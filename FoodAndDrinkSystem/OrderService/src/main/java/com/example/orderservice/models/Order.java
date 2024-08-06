/*
 * @ (#) Order.java     1.0     5/22/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.orderservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 2:27 AM 5/22/2024
 * @version: 1.0
 */
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;
    @Column(name = "customer_id")
    private long customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_phone")
    private String customerPhone;
    @Column(name = "total")
    private double total;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "status")
    private String status;
    @Column(name = "shipping_address")
    private String shippingAddress;
    @Column(name = "note")
    private String note;
    private User user;



}
