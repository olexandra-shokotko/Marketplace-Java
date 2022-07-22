package com.example.marketplace.repository;

import com.example.marketplace.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public interface UserRepo extends JpaRepository<User, Long> {

//    User findByFirstname(String firstname);
    User findByLastname(String lastname);

}