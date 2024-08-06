package com.example.saleservice;

import com.example.saleservice.models.Sale;
import com.example.saleservice.repositories.SaleRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableJpaAuditing
public class SaleServiceApplication {
    private final SaleRepository saleRepository;

    private final Faker faker = new Faker();

    public SaleServiceApplication(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Sale createFakeSale() {
        Sale sale = new Sale();
        sale.setProductId(faker.commerce().productName());
        sale.setCustomerId(faker.idNumber().valid());
        sale.setQuantity(faker.number().numberBetween(1, 10));
        sale.setPrice(faker.number().randomDouble(2, 1, 500));
        sale.setTotal(sale.getQuantity() * sale.getPrice());
        sale.setStatus(faker.options().option("PENDING", "COMPLETED", "CANCELLED"));
        sale.setCreatedDate(LocalDateTime.now());
        sale.setLastModifiedDate(LocalDateTime.now());
        return sale;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                Sale sale = createFakeSale();
                saleRepository.save(sale);
            }
        };
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SaleServiceApplication.class, args);
    }

}
