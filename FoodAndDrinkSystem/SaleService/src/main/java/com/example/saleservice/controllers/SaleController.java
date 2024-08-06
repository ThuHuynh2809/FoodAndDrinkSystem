/*
 * @ (#) SaleController.java     1.0     5/25/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.saleservice.controllers;

import com.example.saleservice.models.Sale;
import com.example.saleservice.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 3:04 PM 5/25/2024
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/sales")
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/sales/{id}")
    public Sale getSaleById(Long id) {
        return saleService.getSaleById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Sale> getSaleByCustomerId(String customerId) {
        return saleService.getSaleByCustomerId(customerId);
    }

    @GetMapping("/product/{productId}")
    public List<Sale> getSaleByProductId(String productId) {
        return saleService.getSaleByProductId(productId);
    }

    @PostMapping("/sales")
    public Sale addSale(Sale sale) {
        return saleService.addSale(sale);
    }

    @PutMapping("/{id}")
    public Sale updateSale(Long id, Sale sale) {
        return saleService.updateSale(id, sale);
    }

    @DeleteMapping("/{id}")
    public void deleteSale(Long id) {
        saleService.deleteSale(id);
    }

}
