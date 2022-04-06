package com.example.onlineshopping.service;

import com.example.onlineshopping.model.Items;
import com.example.onlineshopping.model.Order;
import com.example.onlineshopping.model.User;
import com.example.onlineshopping.repository.ItemsRepositoryImpl;
import com.example.onlineshopping.repository.OrderRepositoryImpl;
import com.example.onlineshopping.repository.UserRepositoryImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {OrderService.class, Items.class, Order.class, User.class})
@ExtendWith(SpringExtension.class)
class OrderServiceTests {
    @Autowired
    private User user;

    @Autowired
    private Order order;

    @Autowired
    private Items items;

    @MockBean
    private ItemsRepositoryImpl itemsRepository;

    @MockBean
    private OrderRepositoryImpl orderRepository;

    @MockBean
    private UserRepositoryImpl userRepository;


    @Autowired
    OrderService orderService;



    @Test
    void testGetAllItems() {
        ArrayList<Items> itemsList = new ArrayList<>();
        when(this.itemsRepository.getAllItems()).thenReturn(itemsList);
        List<Items> actualAllItems = this.orderService.getAllItems();
        assertSame(itemsList, actualAllItems);
        assertTrue(actualAllItems.isEmpty());
        verify(this.itemsRepository).getAllItems();
    }

    @SneakyThrows
    @Test
    void testGetItemById() {
        Items items = new Items(1, "Name", 1L, "Category");

        when(this.itemsRepository.getItemById(anyInt())).thenReturn(Optional.of(items));

        assertSame(items, this.orderService.getItemById(1));
        verify(this.itemsRepository).getItemById(anyInt());
    }

    @Test
    void testSaveItem() {
        when(this.itemsRepository.saveItem((Items) any())).thenReturn(true);
        assertTrue(this.orderService.saveItem(this.items));
        verify(this.itemsRepository).saveItem((Items) any());
    }

    @Test
    void testDeleteItemById() {
        when(this.itemsRepository.deleteItemById(anyInt())).thenReturn(true);
        assertTrue(this.orderService.deleteItemById(2));
        verify(this.itemsRepository).deleteItemById(anyInt());
    }

    @Test
    void testGetAllOrders() {
        ArrayList<Order> orderList = new ArrayList<>();
        when(this.orderRepository.getAllOrders()).thenReturn(orderList);
        List<Order> actualAllOrders = this.orderService.getAllOrders();
        assertSame(orderList, actualAllOrders);
        assertTrue(actualAllOrders.isEmpty());
        verify(this.orderRepository).getAllOrders();
    }

    @Test
    void testGetOrderById() {
        Order order = new Order();
        when(this.orderRepository.getOrderById(anyInt())).thenReturn(Optional.of(order));
        assertSame(order, this.orderService.getOrderById(2));
        verify(this.orderRepository).getOrderById(anyInt());
    }

    @Test
    void testSaveOrder() {
        when(this.orderRepository.saveOrder((Order) any())).thenReturn(true);
        assertTrue(this.orderService.saveOrder(this.order));
        verify(this.orderRepository).saveOrder((Order) any());
    }

    @Test
    void testDeleteOrderById() {
        when(this.orderRepository.deleteOrderById(anyInt())).thenReturn(true);
        assertTrue(this.orderService.deleteOrderById(2));
        verify(this.orderRepository).deleteOrderById(anyInt());
    }

    @Test
    void testOrderStatus() {
        when(this.orderRepository.orderStatus(anyInt())).thenReturn("Order Status");
        assertEquals("Order Status", this.orderService.orderStatus(2));
        verify(this.orderRepository).orderStatus(anyInt());
    }

    @Test
    void testGetAllUsers() {
        ArrayList<User> userList = new ArrayList<>();
        when(this.userRepository.getAllUsers()).thenReturn(userList);
        List<User> actualAllUsers = this.orderService.getAllUsers();
        assertSame(userList, actualAllUsers);
        assertTrue(actualAllUsers.isEmpty());
        verify(this.userRepository).getAllUsers();
    }

    @Test
    void testGetUserById() {
        User user = new User(1, "Erkin Jumaliev", "st. Abdirova 123", 500000);

        when(this.userRepository.getUserById(anyInt())).thenReturn(Optional.of(user));
        assertSame(user, this.orderService.getUserById(1));
        verify(this.userRepository).getUserById(anyInt());
    }

    @Test
    void testSaveUser() {
        when(this.userRepository.saveUser((User) any())).thenReturn(true);
        assertTrue(this.orderService.saveUser(this.user));
        verify(this.userRepository).saveUser((User) any());
    }

    @Test
    void testDeleteUserById() {
        when(this.userRepository.deleteUserById(anyInt())).thenReturn(true);
        assertTrue(this.orderService.deleteUserById(2));
        verify(this.userRepository).deleteUserById(anyInt());
    }

    @Test
    void testPayForOrder() {
        when(this.userRepository.payForOrder((Order) any())).thenReturn(true);
        Order order = mock(Order.class);
        when(order.getUser()).thenReturn(new User(123, "Dr Jane Doe", "42 Main St", 42L));

        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(order);
        when(this.orderRepository.getAllOrders()).thenReturn(orderList);
        assertTrue(this.orderService.payForOrder(123));
        verify(this.userRepository).payForOrder((Order) any());
        verify(this.orderRepository).getAllOrders();
        verify(order).getUser();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme