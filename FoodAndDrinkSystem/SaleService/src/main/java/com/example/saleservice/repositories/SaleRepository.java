/*
 * @ (#) SaleRepository.java     1.0     5/25/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.saleservice.repositories;

import com.example.saleservice.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 3:00 PM 5/25/2024
 * @version: 1.0
 */
@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
    List<Sale> findByCustomerId(String customerId);

    List<Sale> findByProductId(String productId);
}
