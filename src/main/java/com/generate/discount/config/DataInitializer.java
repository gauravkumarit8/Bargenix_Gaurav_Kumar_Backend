package com.generate.discount.config;

import com.generate.discount.model.Product;
import com.generate.discount.model.Users;
import com.generate.discount.service.ProductService;
import com.generate.discount.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) {
        // Create sample products
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Sample Product 1");
        product1.setPrice(19.99);
        productService.createProduct(product1);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Sample Product 2");
        product2.setPrice(29.99);
        productService.createProduct(product2);

        // Create sample users
        Users user1 = new Users();
        user1.setId("user123");
        user1.setName("John Doe");
        user1.setEmail("john@example.com");
        userService.createUser(user1);

        Users user2 = new Users();
        user2.setId("user456");
        user2.setName("Jane Smith");
        user2.setEmail("jane@example.com");
        userService.createUser(user2);
    }
}

