package com.example.onlineshopping.service;

import com.example.onlineshopping.model.Items;
import com.example.onlineshopping.model.Order;
import com.example.onlineshopping.model.User;
import com.example.onlineshopping.service.OrderService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class OrderServiceTest {
    @Autowired
    OrderService orderService;

    @Test
     public void testGetUserById(){
         User expected = orderService.getAllUsers().stream()
                 .filter(user -> user.getId()==1)
                 .findAny().get();
         User actual = orderService.getUserById(1);
         Assertions.assertEquals(actual, expected);
     }
    @Test
    public void testGetOrderById(){
        Order expected = orderService.getAllOrders().stream()
                .filter(order -> order.getId()==1)
                .findAny().get();
        Order actual = orderService.getOrderById(1);
        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void testGetItemById()  {
        Items expected = orderService.getAllItems().stream()
                .filter(item -> item.getId()==1)
                .findAny().get();
        Items actual = orderService.getItemById(1);
        Assertions.assertEquals(actual, expected);
    }
    @Test
    void testDeleteUserById() {
        int size = orderService.getAllUsers().size();
        Assertions.assertTrue(orderService.deleteUserById(2));
        Assertions.assertEquals(orderService.getAllUsers().size(),(size-1));

    }
    @Test
    void testDeleteOrderById() {
        int size = orderService.getAllOrders().size();
        Assertions.assertTrue(orderService.deleteOrderById(2));
        Assertions.assertEquals(orderService.getAllOrders().size(),(size-1));
    }
    @Test
    void testDeleteItemById() {
        int size = orderService.getAllItems().size();
        Assertions.assertTrue(orderService.deleteItemById(2));
        Assertions.assertEquals(orderService.getAllItems().size(),(size-1));
    }
    @Test
    void testSaveUser(){
        int size = orderService.getAllUsers().size();
        User user = new User(123, "Dr Jane Doe", "42 Main St", 42L);
        Assertions.assertTrue(orderService.saveUser(user));
        Assertions.assertEquals(orderService.getAllUsers().size(),(size+1));
    }
    @Test
    void testSaveItem(){
        int size = orderService.getAllItems().size();
        Items item = new Items(123, "Samsung Galaxy M33 5G", 789L, "Smartphones");
        Assertions.assertTrue(orderService.saveItem(item));
        Assertions.assertEquals(orderService.getAllItems().size(),(size+1));
    }
    @Test
    void testSaveOrder(){
        int size = orderService.getAllOrders().size();
        User user = orderService.getUserById(3);
        Order order = new Order(123, LocalDateTime.now(),8L,true,false,user,null);
        Assertions.assertTrue(orderService.saveOrder(order));
        Assertions.assertEquals(orderService.getAllOrders().size(),(size+1));
    }
    @Test
    void testOrderStatus(){
        Assertions.assertEquals( orderService.orderStatus(3),"Please wait delivery!");
    }
    @Test
    void testPayForOrder(){
        User user = orderService.getUserById(3);
        Order order = new Order(478, LocalDateTime.now(),8L,true,false,user,null);
        Assertions.assertTrue(orderService.saveOrder(order));
        Assertions.assertTrue(orderService.payForOrder(order));
    }
}
