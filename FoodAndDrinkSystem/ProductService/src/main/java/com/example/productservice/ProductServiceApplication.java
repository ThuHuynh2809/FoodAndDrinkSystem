package com.example.productservice;

import com.example.productservice.models.Product;
import com.example.productservice.repositories.ProductRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class ProductServiceApplication {

    private final ProductRepository productRepository;

    private final Faker faker = new Faker();

    public ProductServiceApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createFakeProduct(){
        Product product = new Product();
        product.setQuantity(faker.number().numberBetween(1, 100));
        product.setCategory(faker.commerce().department());
        product.setImage(faker.internet().image());
        product.setStatus(String.valueOf(faker.bool().bool()));
        product.setName(faker.commerce().productName());
        product.setDescription(faker.lorem().sentence());
        product.setPrice(faker.number().randomDouble(2, 1, 1000));
        return product;
    }
    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            for (int i = 1; i <= 10; i++){
                Product product = createFakeProduct();
                productRepository.save(product);
            }
        };
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
