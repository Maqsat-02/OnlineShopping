//package com.example.onlineshopping.serviceES;
//
//import com.example.onlineshopping.document.User;
//import com.example.onlineshopping.elasticRepository.UserEsRepository;
//import com.sun.istack.NotNull;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//@NoArgsConstructor
//public class UserERService {
//
//    UserEsRepository userEsRepository;
//
//    @Autowired
//    public UserERService(UserEsRepository userEsRepository) {
//        this.userEsRepository = userEsRepository;
//    }
//
//    public User getById(int id){
//        return userEsRepository.findById(id).get();
//    }
//
//    public User save(@NotNull User user){
//        return userEsRepository.save(user);
//    }
//
//}
