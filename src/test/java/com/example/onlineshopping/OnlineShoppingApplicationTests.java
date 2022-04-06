package com.example.onlineshopping;

import com.example.onlineshopping.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class OnlineShoppingApplicationTests {


    @Autowired
    ApplicationContext javaConfigContext;
    @Test
    void contextLoads() {
        OrderService orderService= javaConfigContext.getBean(OrderService.class);
        Assertions.assertNotNull(orderService);
    }


}
