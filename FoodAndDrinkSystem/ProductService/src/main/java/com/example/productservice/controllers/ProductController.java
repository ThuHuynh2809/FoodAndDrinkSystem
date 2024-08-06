/*
 * @ (#) ProductController.java     1.0     5/22/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.productservice.controllers;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 3:50 AM 5/22/2024
 * @version: 1.0
 */

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @Cacheable(value = "products")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    @Cacheable(value = "product", key = "#id")
    public Product getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/category/{category}")
    @Cacheable(value = "products", key = "#category")
    public List<Product> getProductByCategory(@PathVariable String category) {
        return productService.getProductByCategory(category);
    }

    @PostMapping
    @Cacheable(value = "product", key = "#result.id")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping
    @Cacheable(value = "product", key = "#result.id")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{productId}")
    @Cacheable(value = "product")
    public void deleteProduct(@PathVariable long productId) {
        productService.deleteProductById(productId);
    }


}
