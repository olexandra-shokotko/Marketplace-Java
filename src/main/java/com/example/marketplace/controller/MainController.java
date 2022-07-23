package com.example.marketplace.controller;

import com.example.marketplace.domain.Product;
import com.example.marketplace.domain.User;
import com.example.marketplace.repository.ProductRepo;
import com.example.marketplace.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class MainController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/")
    public String main() {
        return "marketplace";
    }

    @PostMapping("/add-user")
    public User addNewUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PostMapping("/add-product")
    public Product addNewProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @GetMapping("/users")
    public List<User> userList() {
        return userRepo.findAll();
    }

    @GetMapping("/products")
    public List<Product> productList() {
        return productRepo.findAll();
    }

    @PostMapping("/buy-product/{userId}/{productId}")
    public String buyProduct(@PathVariable Long userId,
                                @PathVariable Long productId) {
        User user = userRepo.findById(userId).get();
        Product product = productRepo.findById(productId).get();

        user.setAmountOfMoney(user.getAmountOfMoney() - product.getPrice());
        user.addProduct(product);

        userRepo.flush();
        productRepo.flush();

        return "successful purchase";
    }

    @GetMapping("/products/{id}")
    public Set<Product> productsByUser(@PathVariable Long id) throws Exception {

        return userRepo.findById(id).orElseThrow(() -> new Exception("empty")).getProducts()/*.orElseThrow(() -> new EmployeeNotFoundException(id)*/;
    }

    @GetMapping("/users/{id}")
    public Set<User> usersByProduct(@PathVariable Long id) throws Exception {

        return productRepo.findById(id).orElseThrow(() -> new Exception("empty")).getUsers();
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id) {
        productRepo.deleteById(id);
    }

}
