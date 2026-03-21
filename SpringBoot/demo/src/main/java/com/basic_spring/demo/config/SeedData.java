package com.basic_spring.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.basic_spring.demo.model.Account;
import com.basic_spring.demo.repository.AccountRepository;

@Configuration
public class SeedData {

    @Bean
    CommandLineRunner init(AccountRepository repo, PasswordEncoder encoder) {
        return args -> {

            if (repo.count() == 0) {

                Account admin = new Account();
                admin.setEmail("admin@admin.com");

                // 🔥 MUST BE ENCODED
                admin.setPassword(encoder.encode("1234"));

                admin.setFirstName("Admin");
                admin.setLastName("User");
                admin.setRole("ROLE_ADMIN");

                repo.save(admin);
            }
        };
    }
}