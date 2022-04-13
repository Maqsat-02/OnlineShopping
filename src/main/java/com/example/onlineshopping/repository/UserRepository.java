package com.example.onlineshopping.repository;

import com.example.onlineshopping.model.Order;
import com.example.onlineshopping.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
