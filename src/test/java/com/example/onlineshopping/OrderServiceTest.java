package com.example.onlineshopping;

import com.example.onlineshopping.Config.DBconfig;
import com.example.onlineshopping.model.Items;
import com.example.onlineshopping.model.Order;
import com.example.onlineshopping.model.User;
import com.example.onlineshopping.repository.ItemsRepository;
import com.example.onlineshopping.repository.OrderRepository;
import com.example.onlineshopping.repository.UserRepository;
import com.example.onlineshopping.service.OrderService;

import org.aspectj.lang.annotation.Before;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
//@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {OrderService.class,DBconfig.class})
public class OrderServiceTest {

    @MockBean
    private  ItemsRepository itemsRepository;

    @MockBean
    private  OrderRepository orderRepository;

    @MockBean
    private  UserRepository userRepository;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    public void init() {

        MockitoAnnotations.openMocks(this);
        orderService= new OrderService(itemsRepository,orderRepository,userRepository);
    }

    @Test
     public void testGetUserById(){
        User user=User.builder().id(1).build();
        when(orderService.getUserById(1)).thenReturn(Optional.of(user));
        User user1 = orderService.getUserById(1).get();
        Assertions.assertEquals(user.getId(),user1.getId());
        verify(userRepository, times(1)).findById(1);
     }
    @Test
    public void testGetOrderById(){
        Order expected = Order.builder().id(1).build();
        when(orderService.getOrderById(1)).thenReturn(Optional.of(expected));
        Order actual = orderService.getOrderById(1).get();
        Assertions.assertEquals(actual, expected);
        verify(orderRepository, times(1)).findById(1);
    }
    @Test
    public void testGetItemById()  {
        Items expected = Items.builder().id(1).build();
        when(orderService.getItemById(1)).thenReturn(Optional.of(expected));
        Items actual = orderService.getItemById(1).get();
        Assertions.assertEquals(actual, expected);
        verify(itemsRepository, times(1)).findById(1);
    }
    @Test
    void testGetAllUser(){
        User user1= User.builder().id(1).build();
        User user2 = User.builder().id(2).build();
        given(orderService.getAllUsers()).willReturn(asList(user1, user2));

        //When
        List<User> allActual = orderService.getAllUsers();

        //Then
        assertThat(allActual).containsExactly(user1, user2);
    }
    @Test
    void testGetAllOrder(){
        Order order1= Order.builder().id(1).build();
        Order order2 = Order.builder().id(2).build();
        given(orderService.getAllOrders()).willReturn(asList(order1, order2));

        //When
        List<Order> allActual = orderService.getAllOrders();

        //Then
        assertThat(allActual).containsExactly(order1, order2);
    }
    @Test
    void testGetAllItems(){
        Items items1= Items.builder().id(1).build();
        Items items2 = Items.builder().id(2).build();
        given(orderService.getAllItems()).willReturn(asList(items1, items2));

        //When
        List<Items> allActual = orderService.getAllItems();

        //Then
        assertThat(allActual).containsExactly(items1, items2);
    }
    @Test
    void testDeleteUserById() {
        User expected = User.builder().id(1).build();
        when(orderService.getUserById(1)).thenReturn(Optional.of(expected));
        User actual = orderService.getUserById(1).get();

        Assertions.assertTrue(orderService.deleteUserById(1));

        verify(userRepository, times(1)).deleteById(1);

    }
    @Test
    void testDeleteOrderById() {
        Order expected = Order.builder().id(1).build();
        when(orderService.getOrderById(1)).thenReturn(Optional.of(expected));
        Order actual = orderService.getOrderById(1).get();

        Assertions.assertTrue(orderService.deleteOrderById(1));

        verify(orderRepository, times(1)).deleteById(1);
    }
    @Test
    void testDeleteItemById() {

        Assertions.assertTrue(orderService.deleteItemById(1));

        verify(itemsRepository, times(1)).deleteById(1);
    }
    @Test
    void testSaveUser(){
        User user = new User(123, "Dr Jane Doe", "42 Main St", 42L,null);
        when(orderService.saveUser(Mockito.any(User.class))).thenReturn(user);
        orderService.saveUser(user);

    }
    @Test
    void testSaveItem(){
        Items item = new Items(123, "Samsung Galaxy M33 5G", 789L, "Smartphones",null);
        when(orderService.saveItem(Mockito.any(Items.class))).thenReturn(item);
        orderService.saveItem(item);
    }
    @Test
    void testSaveOrder(){
        Order order = new Order(123, LocalDateTime.now(),8L,true,false,null,null);
        when(orderService.saveOrder(Mockito.any(Order.class))).thenReturn(order);
        orderService.saveOrder(order);
    }
    @Test
    void testOrderStatus(){
        User user = new User(123, "Dr Jane Doe", "42 Main St", 42L,null);
        Order order = new Order(478, LocalDateTime.now(),8L,true,false,user,null);
        when(orderService.orderStatus(order)).thenReturn("Please wait delivery!");
        orderService.orderStatus(order);
  //      Assertions.assertEquals( orderService.orderStatus(3),"Please wait delivery!");
    }
    @Test
    void testPayForOrder(){
        User user = new User(123, "Dr Jane Doe", "42 Main St", 42L,null);
        Order order = new Order(478, LocalDateTime.now(),8L,true,false,user,null);
        user.setOrder(order);
        when(orderService.payForOrder(order)).thenReturn(true);
        orderService.payForOrder(order);
//        Assertions.assertTrue(orderService.saveOrder(order));
//        Assertions.assertTrue(orderService.payForOrder(order));
    }
}
