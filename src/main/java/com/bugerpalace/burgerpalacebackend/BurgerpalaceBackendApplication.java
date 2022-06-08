package com.bugerpalace.burgerpalacebackend;

import com.bugerpalace.burgerpalacebackend.domain.Role;
import com.bugerpalace.burgerpalacebackend.domain.User;
import com.bugerpalace.burgerpalacebackend.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class BurgerpalaceBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BurgerpalaceBackendApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
/*
    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            //userService.saveRole(new Role(null, "ROLE_MANAGER"));
            //userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "admin", "Calle de la pirutleta", "admin@mail.com", "123321123", "admin", new ArrayList<>(), null));

            userService.addRoleToUser("admin@mail.com", "ROLE_ADMIN");
        };
    }

 */
}
