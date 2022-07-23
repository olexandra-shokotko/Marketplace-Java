package com.example.marketplace.repository;

import com.example.marketplace.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByLastname(String lastname);

    @Override
    Optional<User> findById(Long id);

}