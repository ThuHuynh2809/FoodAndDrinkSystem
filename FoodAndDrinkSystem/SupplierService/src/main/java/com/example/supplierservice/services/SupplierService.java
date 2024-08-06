/*
 * @ (#) SupplierService.java     1.0     5/25/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.supplierservice.services;

import com.example.supplierservice.models.Supplier;
import com.example.supplierservice.repositories.SupplierRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 9:54 PM 5/25/2024
 * @version: 1.0
 */
@Slf4j
@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier supplier) {
        Supplier supplierToUpdate = supplierRepository.findById(id).orElse(null);
        if (supplierToUpdate == null) {
            return null;
        }
        supplierToUpdate.setName(supplier.getName());
        supplierToUpdate.setAddress(supplier.getAddress());
        supplierToUpdate.setPhone(supplier.getPhone());
        supplierToUpdate.setEmail(supplier.getEmail());
        return supplierRepository.save(supplierToUpdate);
    }
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }


}
