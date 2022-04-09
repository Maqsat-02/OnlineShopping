package com.example.onlineshopping;

import com.example.onlineshopping.model.Order;
import com.example.onlineshopping.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.onlineshopping.service.OrderService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication(scanBasePackages = "com.example.onlineshopping")
public class OnlineShoppingApplication {

    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(OnlineShoppingApplication.class, args);
//        ApplicationContext ctx = new AnnotationConfigApplicationContext();
        OrderService orderService = context.getBean("orderService",OrderService.class);
        Order order= orderService.getOrderById(1);
        System.out.println(order);
        System.out.println(orderService.orderStatus(2));
        System.out.println(orderService.getAllOrders().size());
        User user= orderService.getUserById(1);
        order.setId(14);
        order.setUser(user);
        System.out.println(orderService.saveOrder(order));
        System.out.println(orderService.getAllOrders().size());


    }

}
