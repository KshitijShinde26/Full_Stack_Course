package com.basic_spring.demo.config;

import com.basic_spring.demo.model.Account;
import com.basic_spring.demo.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SeedData {

	@Bean
	CommandLineRunner init(AccountRepository repo, PasswordEncoder encoder) {
	    return args -> {

	        // ✅ FIX: use count instead of findByEmail
	        if (repo.count() == 0) {

	            Account user = new Account();
	            user.setEmail("admin@gmail.com");
	            user.setPassword(encoder.encode("1234"));
	            user.setFirstName("Admin");
	            user.setLastName("User");
	            user.setRole("ROLE_ADMIN");

	            repo.save(user);
	        }
	    };
	}
}