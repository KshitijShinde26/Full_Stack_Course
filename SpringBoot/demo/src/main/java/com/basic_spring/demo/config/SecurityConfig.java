package com.basic_spring.demo.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth

                // Public URLs
                .requestMatchers("/", "/login", "/register", "/css/**").permitAll()

                // Profile → any logged-in user
                .requestMatchers("/profile/**").authenticated()

                // Admin → only ADMIN role
                .requestMatchers("/admin/**").hasRole("ADMIN")

                // Editor → ADMIN or EDITOR
                .requestMatchers("/editor/**").hasAnyRole("ADMIN", "EDITOR")

                // Authority-based example
                .requestMatchers("/test/**").hasAuthority("ADMIN_ACCESS")

                // Any other request
                .anyRequest().authenticated()
            )

            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
            )

            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}