package com.example.supplierservice;

import com.example.supplierservice.models.Supplier;
import com.example.supplierservice.repositories.SupplierRepository;
import com.example.supplierservice.services.SupplierService;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaAuditing
public class    SupplierServiceApplication {

    private final SupplierRepository supplierRepository;
    private final Faker faker = new Faker();
    public SupplierServiceApplication(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            for (int i = 0; i < 10; i++) {
                Supplier supplier = createFakeSupplier();
                supplierRepository.save(supplier);
            }
        };
    }
    private Supplier createFakeSupplier() {
        Supplier supplier = new Supplier();
        supplier.setId(faker.number().randomNumber());
        supplier.setName(faker.company().name());
        supplier.setAddress(faker.address().fullAddress());
        supplier.setPhone(faker.phoneNumber().cellPhone());
        supplier.setEmail(faker.internet().emailAddress());
        return supplier;
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SupplierServiceApplication.class, args);
    }

}
