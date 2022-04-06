package com.example.onlineshopping;

import com.example.onlineshopping.model.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.onlineshopping.service.OrderService;

@SpringBootApplication(scanBasePackages = {"com.example.onlineshopping.service","com.example.onlineshopping.repository","com.example.onlineshopping.model"})
public class OnlineShoppingApplication {

    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(OnlineShoppingApplication.class, args);
//        ApplicationContext ctx = new AnnotationConfigApplicationContext();
        OrderService orderService = context.getBean("orderService",OrderService.class);
        Order order= orderService.getOrderById(1);
        System.out.println(order);
        System.out.println(orderService.orderStatus(2));


    }

}
