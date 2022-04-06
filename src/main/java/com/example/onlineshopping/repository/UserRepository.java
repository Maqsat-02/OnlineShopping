package com.example.onlineshopping.repository;

import com.example.onlineshopping.model.Order;
import com.example.onlineshopping.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
    List<User> getAllUsers();
    Optional<User> getUserById(int id);
    boolean saveUser(User user);
    boolean deleteUserById(int id);
    boolean payForOrder(Order order);
}
