//package com.example.onlineshopping.controller;
//
//import com.example.onlineshopping.document.User;
//import com.example.onlineshopping.serviceES.UserERService;
//import org.hibernate.annotations.Parameter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//    @Autowired
//    UserERService userERService;
//
//    @PostMapping(value = "/add")
//    public User save(@RequestBody User user){
//        return userERService.save(user);
//    }
//
//    @GetMapping(value = "getById/{id}")
//    public User getById( int id){
//        return userERService.getById(id);
//    }
//}
