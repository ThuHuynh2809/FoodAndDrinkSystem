/*
 * @ (#) User.java     1.0     5/22/2024
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

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 2:35 AM 5/22/2024
 * @version: 1.0
 */
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    @Column(name = "user_name")
    private String name;
}
