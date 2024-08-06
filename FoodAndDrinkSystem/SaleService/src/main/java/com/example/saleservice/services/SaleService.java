/*
 * @ (#) SaleService.java     1.0     5/25/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.saleservice.services;

import com.example.saleservice.models.Sale;
import com.example.saleservice.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 3:01 PM 5/25/2024
 * @version: 1.0
 */
@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Cacheable(value = "sales")
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Cacheable(value = "sales", key = "#id")
    public Sale getSaleById(Long id) {
        return saleRepository.findById(id).orElse(null);
    }

    @Cacheable(value = "sales")
    public List<Sale> getSaleByCustomerId(String customerId) {
        return saleRepository.findByCustomerId(customerId);

    }

    @Cacheable(value = "sales")
    public List<Sale> getSaleByProductId(String productId) {
        return saleRepository.findByProductId(productId);
    }

    @Cacheable(value = "sales")
    public Sale addSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Cacheable(value = "sales", key = "#id")
    public Sale updateSale(Long id, Sale sale) {
        Sale saleToUpdate = saleRepository.findById(id).orElse(null);
        if (saleToUpdate != null) {
            saleToUpdate.setProductId(sale.getProductId());
            saleToUpdate.setCustomerId(sale.getCustomerId());
            saleToUpdate.setQuantity(sale.getQuantity());
            saleToUpdate.setPrice(sale.getPrice());
            saleToUpdate.setTotal(sale.getTotal());
            saleToUpdate.setStatus(sale.getStatus());
            return saleRepository.save(saleToUpdate);
        }
        return null;
    }

    @Cacheable(value = "sales", key = "#id")
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }



}
