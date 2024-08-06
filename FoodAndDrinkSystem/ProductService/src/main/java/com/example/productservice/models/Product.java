/*
 * @ (#) Product.java     1.0     5/22/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.productservice.models;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 3:43 AM 5/22/2024
 * @version: 1.0
 */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "category")
    private String category;

    @Column(name = "image")
    private String image;

    @Column(name = "status")
    private String status;
}
