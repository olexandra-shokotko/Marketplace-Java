package com.example.marketplace.repository;

import com.example.marketplace.domain.Product;
import com.example.marketplace.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Product findByName(String name);

}