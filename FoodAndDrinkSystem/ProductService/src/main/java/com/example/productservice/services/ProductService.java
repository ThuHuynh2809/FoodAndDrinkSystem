/*
 * @ (#) ProductService.java     1.0     5/22/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.productservice.services;

import com.example.productservice.models.Product;
import com.example.productservice.repositories.ProductRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 3:47 AM 5/22/2024
 * @version: 1.0
 */
@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


// Tạo lỗi giả để kiểm tra Circuit Breaker
//    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackGetAllProduct")
//    public List<Product> getAllProduct() {
//        if (new Random().nextInt(10) < 5) { // Tạo lỗi giả ngẫu nhiên
//            throw new RuntimeException("Simulated error");
//        }
//        return productRepository.findAll();
//    }
// kiểm tra bằng postman http://localhost:8080/actuator/health để xem trạng thái của Circuit Breaker


    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackGetAllProduct")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackGetProductById")
    public Product getProductById(long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackGetProductByCategory")
    public List<Product> getProductByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackAddProduct")
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackUpdateProduct")
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackDeleteProductById")
    public void deleteProductById(long productId) {
        productRepository.deleteById(productId);
    }

    // Fallback methods
    public List<Product> fallbackGetAllProduct(Throwable t) {
        return List.of();
    }

    public Product fallbackGetProductById(long id, Throwable t) {
        return new Product();
    }

    public List<Product> fallbackGetProductByCategory(String category, Throwable t) {
        return List.of();
    }

    public Product fallbackAddProduct(Product product, Throwable t) {
        return new Product();
    }

    public Product fallbackUpdateProduct(Product product, Throwable t) {
        return new Product();
    }

    public void fallbackDeleteProductById(long productId, Throwable t) {


    }
}
