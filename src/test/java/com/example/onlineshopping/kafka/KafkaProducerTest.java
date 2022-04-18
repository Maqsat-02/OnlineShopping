package com.example.onlineshopping.kafka;

import com.example.onlineshopping.model.Items;
import com.example.onlineshopping.model.Order;
import com.example.onlineshopping.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static org.mockito.Mockito.*;

class KafkaProducerTest {
    @Mock
    KafkaTemplate<String, Object> kafkaTemplate;
    @Mock
    Logger log;
    @InjectMocks
    KafkaProducer kafkaProducer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendMessage() {
        User user = new User(123, "Dr Jane Doe", "42 Main St", 42L,null);
        Order order = new Order(478, LocalDateTime.now(),8L,true,false,user,null);
        String result = kafkaProducer.sendMessage(order);
        Assertions.assertEquals("json message sent successfully", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme