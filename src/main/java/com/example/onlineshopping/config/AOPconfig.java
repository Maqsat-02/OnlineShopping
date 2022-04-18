package com.example.onlineshopping.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//Step-3 - Add the annotation
@EnableAspectJAutoProxy
@ComponentScan("com.example.onlineshopping")
public class AOPconfig {
}
