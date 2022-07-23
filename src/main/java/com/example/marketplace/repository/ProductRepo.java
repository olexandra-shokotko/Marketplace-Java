package com.example.marketplace.repository;

import com.example.marketplace.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Product findByName(String name);

    @Override
    Optional<Product> findById(Long id);
}