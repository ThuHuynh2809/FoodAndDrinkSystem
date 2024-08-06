/*
 * @ (#) ProductRepository.java     1.0     5/22/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 3:47 AM 5/22/2024
 * @version: 1.0
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
}
