package com.example.marketplace.controller;

import com.example.marketplace.domain.Product;
import com.example.marketplace.domain.User;
import com.example.marketplace.repository.ProductRepo;
import com.example.marketplace.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }

    @PostMapping("/add-user")
    public String addNewUser(@RequestParam String firstname,
                              @RequestParam String lastname,
                              @RequestParam Float amountOfMoney,
                              Model model) {
        userRepo.save(new User(firstname, lastname, amountOfMoney));

        return "redirect:/";
    }

    @PostMapping("/add-product")
    public String addNewProduct(@RequestParam String name,
                              @RequestParam Float price,
                              Model model) {
        productRepo.save(new Product(name, price));

        return "redirect:/";
    }

    @GetMapping("/users")
    public String userList(Model model) {
        model.addAttribute("users", userRepo.findAll());

        return "userList";
    }

    @GetMapping("/products")
    public String productList(Model model) {
        model.addAttribute("products", productRepo.findAll());

        return "productList";
    }

    @PostMapping("/buy-product")
    public String buyProduct(@RequestParam Long userId,
                                @RequestParam Long productId,
                                Model model) {
        User user = userRepo.findById(userId).get();
        Product product = productRepo.findById(productId).get();

        user.setAmountOfMoney(user.getAmountOfMoney() - product.getPrice());
        user.addProduct(product);

        userRepo.flush();
        productRepo.flush();

        return "redirect:/";
    }

    @GetMapping("/products/{user}")
    public String productsByUser(@PathVariable User user,
                                         Model model) {

        model.addAttribute("products", userRepo.findById(user.getUserId()).get().getProducts());
        model.addAttribute("user", user);

        return "productList";
    }

    @GetMapping("/users/{product}")
    public String usersByProduct(@PathVariable Product product,
                                         Model model) {

        model.addAttribute("users", productRepo.findById(product.getProductId()).get().getUsers());
        model.addAttribute("product", product);

        return "userList";
    }

/*    @GetMapping("/users/{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);

        return "userEdit";
    }*/

/*    @PostMapping
    public String userSave(@RequestParam String firstname,
                           @RequestParam String lastname,
                           @RequestParam Map<String, String> form,
                           @RequestParam("userId") User user) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);

        return "redirect:/user";
    }*/
}
