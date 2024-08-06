/*
 * @ (#) OrderRepository.java     1.0     5/22/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.orderservice.repositories;

import com.example.orderservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 2:41 AM 5/22/2024
 * @version: 1.0
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
