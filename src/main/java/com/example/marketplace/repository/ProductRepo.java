package com.example.marketplace.repository;

import com.example.marketplace.domain.Product;
import com.example.marketplace.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Product findByName(String name);

    @Override
    Optional<Product> findById(Long id);
}