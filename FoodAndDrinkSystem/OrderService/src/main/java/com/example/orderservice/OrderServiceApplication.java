package com.example.orderservice;

import com.example.orderservice.models.Order;
import com.example.orderservice.models.User;
import com.example.orderservice.repositories.OrderRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class OrderServiceApplication {

    private final OrderRepository orderRepository;
    private final Faker faker = new Faker();

    public OrderServiceApplication(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    private Order createFakeOrder(){
        Order order = new Order();
        order.setCustomerId(faker.number().randomNumber());
        order.setCustomerName(faker.name().fullName());
        order.setCustomerPhone(faker.phoneNumber().cellPhone());
        order.setTotal(faker.number().randomDouble(2, 1, 1000));
        order.setPaymentMethod(faker.lorem().word());
        order.setNote(faker.lorem().sentence());
        order.setOrderDate(faker.date().past(10, java.util.concurrent.TimeUnit.DAYS).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
        order.setStatus(faker.lorem().word());
        order.setShippingAddress(faker.address().fullAddress());
        return order;
    }
    private User createFakeUser(){
        User user = new User();
        user.setId(faker.number().randomNumber());
        user.setName(faker.name().fullName());
        return user;
    }
    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            for (int i = 1; i <= 10; i++){
                Order order = createFakeOrder();
                User user = createFakeUser();
                order.setUser(user);
                orderRepository.save(order);
            }
        };
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
