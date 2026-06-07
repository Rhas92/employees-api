package com.example.employees_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("ramon").isEmpty()) {
                AppUser user = new AppUser(
                        "ramon",
                        passwordEncoder.encode("1234"),   // ← the real hash is created HERE
                        "ADMIN"
                );
                userRepository.save(user);
            }
        };
    }
}
