package com.example.onlineshopping.kafka;

import com.example.onlineshopping.model.Items;
import com.example.onlineshopping.model.Order;
import com.example.onlineshopping.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static org.mockito.Mockito.*;

class KafkaConsumerTest {
    @Mock
    Logger log;
    @InjectMocks
    KafkaConsumer kafkaConsumer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testReceivedMessage() throws JsonProcessingException {
        User user = new User(123, "Dr Jane Doe", "42 Main St", 42L,null);
        Order order = new Order(478, LocalDateTime.now(),8L,true,false,user,null);
        kafkaConsumer.receivedMessage(order);  }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme