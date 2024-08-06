/*
 * @ (#) SupplierController.java     1.0     5/25/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.supplierservice.controllers;

import com.example.supplierservice.models.Supplier;
import com.example.supplierservice.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 9:56 PM 5/25/2024
 * @version: 1.0
 */
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/suppliers/{id}")
    public Supplier getSupplierById(Long id) {
        return supplierService.getSupplierById(id);
    }

    @PostMapping
    public Supplier createSupplier(Supplier supplier) {
        return supplierService.createSupplier(supplier);
    }

    @PutMapping("/suppliers/{id}")
    public Supplier updateSupplier(Long id, Supplier supplier) {
        return supplierService.updateSupplier(id, supplier);
    }

    @DeleteMapping ("/suppliers/{id}")
    public void deleteSupplier(Long id) {
        supplierService.deleteSupplier(id);
    }
}
