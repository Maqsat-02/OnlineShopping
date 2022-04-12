package com.example.onlineshopping.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Configuration
@org.aspectj.lang.annotation.Aspect
@Slf4j
public class Aspect {

    @Around(value = "Pointcuts.allGetByIDMethods()")
    public Object aroundGetById(ProceedingJoinPoint joinPoint){
        Object result=null;
        log.info("Method: "+ joinPoint.getSignature().getName());
        log.info("Attempting get class {} object by id: {} ",joinPoint.getClass().getName(),joinPoint.getArgs());
        try {
            long start = System.nanoTime();
            result=joinPoint.proceed();
            long end = System.nanoTime();
            log.info("Execution took " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        } catch (Throwable e) {
            e.printStackTrace();
            log.info("Error while getting");
        }
        return result;
    }

    @AfterThrowing(value = "Pointcuts.allGetByIDMethods()")
    public void logExceptions(JoinPoint joinPoint) {
        log.info("Exception thrown in {} Method={}",joinPoint.getSignature().getName(),joinPoint.toString());
    }

    @Before(value = "Pointcuts.allGetAllMethods()")
    public void beforeGetAll(JoinPoint joinPoint){
        log.info("Method: "+ joinPoint.getSignature().getName());
        log.info("Attempting get all data class {}  ",joinPoint.getClass().getName());
    }

    @AfterReturning(value="Pointcuts.allGetAllMethods()",returning="returnSize")
    public void returnSize(JoinPoint joinPoint,int returnSize){
        log.info("{} method executed. Returned list size: {}",joinPoint.getSignature().getName(),returnSize);
    }
    @After(value = "Pointcuts.allSaveMethods()")
    public void afterSave(JoinPoint joinPoint){
        log.info("Running After Advice for {} method. Passed arguments :{}",joinPoint.getSignature().getName(),joinPoint.getArgs());
    }
}
