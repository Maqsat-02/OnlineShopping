package com.example.onlineshopping.service;

import com.example.onlineshopping.model.Items;
import com.example.onlineshopping.model.Order;
import com.example.onlineshopping.model.User;
import com.example.onlineshopping.repository.ItemsRepositoryImpl;
import com.example.onlineshopping.repository.OrderRepositoryImpl;
import com.example.onlineshopping.repository.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {OrderService.class, Items.class, Order.class, User.class})
@ExtendWith(SpringExtension.class)
class OrderServiceTest {
    @Autowired
    private User user;

    @Autowired
    private Order order;

    @Autowired
    private Items items;

    @MockBean
    private ItemsRepositoryImpl itemsRepositoryImpl;

    @MockBean
    private OrderRepositoryImpl orderRepositoryImpl;

    @MockBean
    private UserRepositoryImpl userRepositoryImpl;

    @Mock
    ItemsRepositoryImpl itemsRepository;
    @Mock
    OrderRepositoryImpl orderRepository;
    @Mock
    UserRepositoryImpl userRepository;
    @Autowired
    OrderService orderService;

//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    void testGetAllItems() {
        when(itemsRepository.getAllItems()).thenReturn(Arrays.<Items>asList(new Items(0, "name", 0L, "category")));

        List<Items> result = orderService.getAllItems();
        Assertions.assertEquals(Arrays.<Items>asList(new Items(0, "name", 0L, "category")), result);
    }

    @Test
    void testGetAllItems2() {
        ArrayList<Items> itemsList = new ArrayList<>();
        when(this.itemsRepositoryImpl.getAllItems()).thenReturn(itemsList);
        List<Items> actualAllItems = this.orderService.getAllItems();
        assertSame(itemsList, actualAllItems);
        assertTrue(actualAllItems.isEmpty());
        verify(this.itemsRepositoryImpl).getAllItems();
    }



    @Test
    void testGetItemById2() throws ClassNotFoundException {
        Items items = new Items(1, "Name", 1L, "Category");

        when(this.itemsRepositoryImpl.getItemById(anyInt())).thenReturn(Optional.of(items));
        assertSame(items, this.orderService.getItemById(1));
        verify(this.itemsRepositoryImpl).getItemById(anyInt());
    }

    @Test
    void testSaveItem() {
        when(itemsRepository.saveItem(any())).thenReturn(true);

        boolean result = orderService.saveItem(new Items(6, "Iphone 12 64GB", 420000, "Smartphones"));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testSaveItem2() {
        when(this.itemsRepositoryImpl.saveItem((Items) any())).thenReturn(true);
        assertTrue(this.orderService.saveItem(this.items));
        verify(this.itemsRepositoryImpl).saveItem((Items) any());
    }

    @Test
    void testSaveItem3() {
        when(this.itemsRepositoryImpl.saveItem((Items) any())).thenReturn(false);
        assertFalse(this.orderService.saveItem(this.items));
        verify(this.itemsRepositoryImpl).saveItem((Items) any());
    }

    @Test
    void testDeleteItemById() {
        when(itemsRepository.deleteItemById(anyInt())).thenReturn(true);

        boolean result = orderService.deleteItemById(1);
        Assertions.assertEquals(true, result);
    }

    @Test
    void testDeleteItemById2() {
        when(this.itemsRepositoryImpl.deleteItemById(anyInt())).thenReturn(true);
        assertTrue(this.orderService.deleteItemById(2));
        verify(this.itemsRepositoryImpl).deleteItemById(anyInt());
    }

    @Test
    void testDeleteItemById3() {
        when(this.itemsRepositoryImpl.deleteItemById(anyInt())).thenReturn(false);
        assertFalse(this.orderService.deleteItemById(3));
        verify(this.itemsRepositoryImpl).deleteItemById(anyInt());
    }

    @Test
    void testGetAllOrders() {
        when(orderRepository.getAllOrders()).thenReturn(Arrays.<Order>asList(new Order(0, LocalDateTime.of(2022, Month.APRIL, 6, 10, 38, 55), 0L, true, true, new User(0, "fullName", "address", 0L), Arrays.<Items>asList(new Items(0, "name", 0L, "category")))));

        List<Order> result = orderService.getAllOrders();
        Assertions.assertEquals(Arrays.<Order>asList(new Order(0, LocalDateTime.of(2022, Month.APRIL, 6, 10, 38, 55), 0L, true, true, new User(0, "fullName", "address", 0L), Arrays.<Items>asList(new Items(0, "name", 0L, "category")))), result);
    }

    @Test
    void testGetAllOrders2() {
        ArrayList<Order> orderList = new ArrayList<>();
        when(this.orderRepositoryImpl.getAllOrders()).thenReturn(orderList);
        List<Order> actualAllOrders = this.orderService.getAllOrders();
        assertSame(orderList, actualAllOrders);
        assertTrue(actualAllOrders.isEmpty());
        verify(this.orderRepositoryImpl).getAllOrders();
    }

    @Test
    void testGetOrderById() {
        when(orderRepository.getOrderById(anyInt())).thenReturn(null);

        Order result = orderService.getOrderById(1);
        Assertions.assertEquals(new Order(1, LocalDateTime.of(2022, Month.APRIL, 4, 11, 30), 0, true, true,
                new User(3, "Serik Ospanov", "st. Aitiev 123", 100000),
                List.<Items>of(new Items(2, "SAMSUNG GALAXY S8 64GB", 253990, "Smartphones"))), result);
    }

    @Test
    void testGetOrderById2() {
        Order order = new Order();
        when(this.orderRepositoryImpl.getOrderById(anyInt())).thenReturn(Optional.of(order));
        assertSame(order, this.orderService.getOrderById(2));
        verify(this.orderRepositoryImpl).getOrderById(anyInt());
    }

    @Test
    void testSaveOrder() {
        when(orderRepository.saveOrder(any())).thenReturn(true);

        boolean result = orderService.saveOrder(new Order(4, LocalDateTime.of(2022, Month.APRIL, 6, 10, 38, 55), 0L, true, true, new User(4, "fullName", "address", 0L), List.<Items>of(new Items(6, "name", 0L, "category"))));
        assertTrue(result);
    }

    @Test
    void testSaveOrder2() {
        when(this.orderRepositoryImpl.saveOrder((Order) any())).thenReturn(true);
        assertTrue(this.orderService.saveOrder(this.order));
        verify(this.orderRepositoryImpl).saveOrder((Order) any());
    }

    @Test
    void testSaveOrder3() {
        when(this.orderRepositoryImpl.saveOrder((Order) any())).thenReturn(false);
        assertFalse(this.orderService.saveOrder(this.order));
        verify(this.orderRepositoryImpl).saveOrder((Order) any());
    }

    @Test
    void testDeleteOrderById() {
        when(orderRepository.deleteOrderById(anyInt())).thenReturn(true);

        boolean result = orderService.deleteOrderById(1);
        Assertions.assertEquals(true, result);
    }

    @Test
    void testDeleteOrderById2() {
        when(this.orderRepositoryImpl.deleteOrderById(anyInt())).thenReturn(true);
        assertTrue(this.orderService.deleteOrderById(2));
        verify(this.orderRepositoryImpl).deleteOrderById(anyInt());
    }

    @Test
    void testDeleteOrderById3() {
        when(this.orderRepositoryImpl.deleteOrderById(anyInt())).thenReturn(false);
        assertFalse(this.orderService.deleteOrderById(1));
        verify(this.orderRepositoryImpl).deleteOrderById(anyInt());
    }

    @Test
    void testOrderStatus() {
        when(orderRepository.orderStatus(anyInt())).thenReturn("orderStatusResponse");

        String result = orderService.orderStatus(1);
        Assertions.assertEquals("Your order was delivered!!", result);
    }

    @Test
    void testOrderStatus2() {
        when(this.orderRepositoryImpl.orderStatus(anyInt())).thenReturn("Order Status");
        assertEquals("Order Status", this.orderService.orderStatus(2));
        verify(this.orderRepositoryImpl).orderStatus(anyInt());
    }

    @Test
    void testGetAllUsers() {
        when(userRepository.getAllUsers()).thenReturn(Arrays.<User>asList(new User(0, "fullName", "address", 0L)));

        List<User> result = orderService.getAllUsers();
        Assertions.assertEquals(Arrays.<User>asList(new User(0, "fullName", "address", 0L)), result);
    }

    @Test
    void testGetAllUsers2() {
        ArrayList<User> userList = new ArrayList<>();
        when(this.userRepositoryImpl.getAllUsers()).thenReturn(userList);
        List<User> actualAllUsers = this.orderService.getAllUsers();
        assertSame(userList, actualAllUsers);
        assertTrue(actualAllUsers.isEmpty());
        verify(this.userRepositoryImpl).getAllUsers();
    }

    @Test
    void testGetUserById() {
        when(userRepository.getUserById(anyInt())).thenReturn(null);
        User result = orderService.getUserById(1);
        Assertions.assertEquals(new User(1, "Erkin Jumaliev", "st. Abdirova 123", 500000), result);
    }

    @Test
    void testGetUserById2() {
        User user = new User(1, "Dr Jane Doe", "42 Main St", 42L);

        when(this.userRepositoryImpl.getUserById(anyInt())).thenReturn(Optional.of(user));
        assertSame(user, this.orderService.getUserById(1));
        verify(this.userRepositoryImpl).getUserById(anyInt());
    }

    @Test
    void testSaveUser() {
        when(userRepository.saveUser(any())).thenReturn(true);

        boolean result = orderService.saveUser(new User(4, "Robert", "st. Lincoln 123", 0L));
        Assertions.assertEquals(true, result);
    }

    @Test
    void testSaveUser2() {
        when(this.userRepositoryImpl.saveUser((User) any())).thenReturn(true);
        assertTrue(this.orderService.saveUser(this.user));
        verify(this.userRepositoryImpl).saveUser((User) any());
    }

    @Test
    void testSaveUser3() {
        when(this.userRepositoryImpl.saveUser((User) any())).thenReturn(false);
        assertFalse(this.orderService.saveUser(this.user));
        verify(this.userRepositoryImpl).saveUser((User) any());
    }

    @Test
    void testDeleteUserById() {
        when(userRepository.deleteUserById(anyInt())).thenReturn(true);

        boolean result = orderService.deleteUserById(1);
        Assertions.assertEquals(true, result);
    }

    @Test
    void testDeleteUserById2() {
        when(this.userRepositoryImpl.deleteUserById(anyInt())).thenReturn(true);
        assertTrue(this.orderService.deleteUserById(2));
        verify(this.userRepositoryImpl).deleteUserById(anyInt());
    }

    @Test
    void testDeleteUserById3() {
        when(this.userRepositoryImpl.deleteUserById(anyInt())).thenReturn(false);
        assertFalse(this.orderService.deleteUserById(3));
        verify(this.userRepositoryImpl).deleteUserById(anyInt());
    }

    @Test
    void testPayForOrder() {
        when(orderRepository.getAllOrders()).thenReturn(Arrays.<Order>asList(new Order(0, LocalDateTime.of(2022, Month.APRIL, 6, 10, 38, 55), 0L, true, true, new User(0, "fullName", "address", 0L), Arrays.<Items>asList(new Items(0, "name", 0L, "category")))));
        when(userRepository.payForOrder(any())).thenReturn(true);

        boolean result = orderService.payForOrder(1);
        Assertions.assertEquals(true, result);
    }

    @Test
    void testPayForOrder2() {
        when(this.userRepositoryImpl.payForOrder((Order) any())).thenReturn(true);
        Order order = mock(Order.class);
        when(order.getUser()).thenReturn(new User(123, "Dr Jane Doe", "42 Main St", 42L));

        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(order);
        when(this.orderRepositoryImpl.getAllOrders()).thenReturn(orderList);
        assertTrue(this.orderService.payForOrder(123));
        verify(this.userRepositoryImpl).payForOrder((Order) any());
        verify(this.orderRepositoryImpl).getAllOrders();
        verify(order).getUser();
    }

    @Test
    void testPayForOrder3() {
        when(this.userRepositoryImpl.payForOrder((Order) any())).thenReturn(false);
        Order order = mock(Order.class);
        when(order.getUser()).thenReturn(new User(123, "Dr Jane Doe", "42 Main St", 42L));

        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(order);
        when(this.orderRepositoryImpl.getAllOrders()).thenReturn(orderList);
        assertFalse(this.orderService.payForOrder(123));
        verify(this.userRepositoryImpl).payForOrder((Order) any());
        verify(this.orderRepositoryImpl).getAllOrders();
        verify(order).getUser();
    }


}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme