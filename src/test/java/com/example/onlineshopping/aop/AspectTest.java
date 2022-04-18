package com.example.onlineshopping.aop;

import com.example.onlineshopping.service.OrderService;
import org.aspectj.lang.JoinPoint;
import org.hibernate.mapping.Join;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

class AspectTest {
    @Mock
    Logger log;
    @InjectMocks
    Aspect aspect;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAroundGetById() {
        Object result = aspect.aroundGetById(null);
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testLogExceptions() {
        aspect.logExceptions(null);
    }

    @Test
    void testBeforeGetAll() {
        JoinPoint joinPoint =null;
        aspect.beforeGetAll(joinPoint );
    }

    @Test
    void testReturnSize() {
        aspect.returnSize(null, 0);
    }

    @Test
    void testAfterSave() {
        aspect.afterSave(null);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme