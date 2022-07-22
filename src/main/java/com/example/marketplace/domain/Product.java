package com.example.marketplace.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long productId;
    private String name;
    private Float price;

    @ManyToMany(mappedBy = "products")
    private Set<User> users;

    public Product() {
    }

    public Product(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public void addUser(User user) {
        users.add(user);
        user.getProducts().add(this);
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long id) {
        this.productId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

/*    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", users=" + users +
                '}';
    }*/
}
