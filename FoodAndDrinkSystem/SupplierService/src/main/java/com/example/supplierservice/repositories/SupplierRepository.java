/*
 * @ (#) SupplierRepository.java     1.0     5/25/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.supplierservice.repositories;

import com.example.supplierservice.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 9:53 PM 5/25/2024
 * @version: 1.0
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{
}
