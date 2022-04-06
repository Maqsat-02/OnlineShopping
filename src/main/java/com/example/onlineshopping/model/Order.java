package com.example.onlineshopping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class Order {
    int id;
    LocalDateTime orderDate;
    long totalPrice;
    boolean isPaid;
    boolean isDelivered;
    User user;
    List<Items> orderItems;

    public static List<Order> getOrders() {
        List<User> userList= User.getUsers();
        List<Items> itemsList= Items.getItems();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        Order order1 = Order.builder()
                .id(1)
                .orderDate(LocalDateTime.parse("2022-04-01 11:30", formatter))
                .totalPrice(0)
                .isPaid(true)
                .isDelivered(true)
                .user(userList.get(0))
                .orderItems(List.of(itemsList.get(1)))
                .build();

        Order order2 = Order.builder()
                .id(2)
                .orderDate(LocalDateTime.parse("2022-04-03 17:27", formatter))
                .totalPrice(0)
                .isPaid(false)
                .isDelivered(false)
                .user(userList.get(1))
                .orderItems(List.of(itemsList.get(2)))
                .build();

        Order order3 = Order.builder()
                .id(3)
                .orderDate(LocalDateTime.parse("2022-04-06 20:05", formatter))
                .totalPrice(0)
                .isPaid(true)
                .isDelivered(false)
                .user(userList.get(2))
                .orderItems(List.of(itemsList.get(4)))
                .build();

        return Arrays.asList(order1,order2,order3);
    }
}
