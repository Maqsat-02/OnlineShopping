package com.example.onlineshopping.service;

import com.example.onlineshopping.repository.ItemsRepositoryImpl;
import com.example.onlineshopping.repository.OrderRepositoryImpl;
import com.example.onlineshopping.repository.UserRepositoryImpl;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.onlineshopping.model.Items;
import com.example.onlineshopping.model.Order;
import com.example.onlineshopping.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Slf4j
@Service("orderService")
@NoArgsConstructor
public class OrderService {
    @Autowired
    ItemsRepositoryImpl itemsRepository;
    @Autowired
    OrderRepositoryImpl orderRepository;
    @Autowired
    UserRepositoryImpl userRepository;

    public OrderService(ItemsRepositoryImpl itemsRepository, OrderRepositoryImpl orderRepository, UserRepositoryImpl userRepository) {
        this.itemsRepository = itemsRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public List<Items> getAllItems() {
       log.info("Get all items method called");
       return itemsRepository.getAllItems();
   }
    public Items getItemById(int id) throws ClassNotFoundException {
        log.info("Get item by id:{} method called",id);
       return itemsRepository.getItemById(id).orElse(null);
   }
    public boolean saveItem(Items item) {
        log.info("Save item:{} method called",item);
        return itemsRepository.saveItem(item);
   }
    public boolean deleteItemById(int id) {
        log.info("Delete item by id:{} method called",id);
        return itemsRepository.deleteItemById(id);
    }

    public List<Order> getAllOrders() {
        log.info("Get all orders method called");
        return  orderRepository.getAllOrders();
   }
    public Order getOrderById(int id) {
        log.info("Get order by id:{} method called",id);
        return orderRepository.getOrderById(id).orElse(null);
   }
    public boolean saveOrder(Order order) {
        log.info("Save item:{} method called",order);
        return orderRepository.saveOrder(order);
   }
    public boolean deleteOrderById(int id){
        log.info("Delete item by id:{} method called",id);
        return orderRepository.deleteOrderById(id);
    }
    public String orderStatus(int id) {
        log.info("Order status of order by id:{} method called",id);
        return  orderRepository.orderStatus(id);
    }
    public List<User> getAllUsers() {
        log.info("Get all users method called");
        return userRepository.getAllUsers();
    }
    public User getUserById(int id){
        log.info("Get user by id:{} method called",id);
        return  userRepository.getUserById(id).orElse(null);
    }
    public boolean saveUser(User user){
        log.info("Save user:{} method called",user);
        return  userRepository.saveUser(user);
    }
    public boolean deleteUserById(int id){
        log.info("Delete user by id:{} method called",id);
        return userRepository.deleteUserById(id);
    }
    boolean payForOrder(int userId){
        log.info("Paying for order of userId:{} method called",userId);
        Order order = getAllOrders().stream().filter(x->x.getUser().getId()==userId).findAny().
                orElseThrow(Error::new);
        return userRepository.payForOrder(order);
    }

}
