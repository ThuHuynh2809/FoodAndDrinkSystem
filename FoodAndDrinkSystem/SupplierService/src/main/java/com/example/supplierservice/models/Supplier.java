/*
 * @ (#) Supplier.java     1.0     5/25/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.supplierservice.models;

import jakarta.persistence.*;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 9:45 PM 5/25/2024
 * @version: 1.0
 */
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long id;

    @Column(name = "supplier_name")
    private String name;

    @Column(name = "supplier_address")
    private String address;

    @Column(name = "supplier_phone")
    private String phone;

    @Column(name = "supplier_email")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Supplier() {
    }

    public Supplier(Long id, String name, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
