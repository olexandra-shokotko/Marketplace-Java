package com.example.marketplace.controller;

import com.example.marketplace.domain.Product;
import com.example.marketplace.domain.User;
import com.example.marketplace.repository.ProductRepo;
import com.example.marketplace.repository.UserRepo;
import com.example.marketplace.service.InternalServerException;
import com.example.marketplace.service.NotEnoughMoneyException;
import org.springframework.beans.factory.annotation.Autowired;
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

        if (user.getAmountOfMoney() < product.getPrice()) {
            throw new NotEnoughMoneyException();
        }

        user.setAmountOfMoney(user.getAmountOfMoney() - product.getPrice());
        user.addProduct(product);

        userRepo.flush();
        productRepo.flush();

        return "successful purchase";
    }

    @GetMapping("/products/{id}")
    public Set<Product> productsByUser(@PathVariable Long id) {

        return userRepo.findById(id).orElseThrow(InternalServerException::new).getProducts();
    }

    @GetMapping("/users/{id}")
    public Set<User> usersByProduct(@PathVariable Long id) {

        return productRepo.findById(id).orElseThrow(InternalServerException::new).getUsers();
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) throws InternalServerException {
        userRepo.deleteById(id);
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id) throws InternalServerException {
        productRepo.deleteById(id);
    }

}
