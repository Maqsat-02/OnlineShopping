package com.example.onlineshopping.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution (* com.example.onlineshopping.service.OrderService.get*ById(int ))")
    public void allGetByIDMethods(){}

    @Pointcut("execution (* com.example.onlineshopping.service.OrderService.getAll*(..))")
    public void allGetAllMethods(){}

    @Pointcut("execution(* com.example.onlineshopping.service.OrderService.save*(..))")
    public void allSaveMethods(){};

}
