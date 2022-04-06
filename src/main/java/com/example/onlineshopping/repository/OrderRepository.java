package com.example.onlineshopping.repository;

import com.example.onlineshopping.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(int id);
    boolean saveOrder(Order order);
    boolean deleteOrderById(int id);
    String orderStatus(int id);
}
