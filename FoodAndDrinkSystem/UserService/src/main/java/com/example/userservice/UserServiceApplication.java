package com.example.userservice;

import com.example.userservice.models.User;
import com.example.userservice.repositories.UserRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {

    @Autowired
    private final UserRepository userRepository;

    private final Faker faker = new Faker();
    public UserServiceApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            for (int i = 0; i < 10; i++) {
                User user = createFakeUser();
                userRepository.save(user);
            }
        };
    }

    private User createFakeUser() {
        User user = new User();
        user.setId(faker.number().randomNumber());
        user.setUsername(faker.name().fullName());
        user.setEmail(faker.internet().emailAddress());
        user.setPhone(faker.phoneNumber().cellPhone());
        user.setAddress(faker.address().fullAddress());
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
