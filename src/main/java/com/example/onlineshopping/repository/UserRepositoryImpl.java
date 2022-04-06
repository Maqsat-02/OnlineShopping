package com.example.onlineshopping.repository;

import com.example.onlineshopping.model.Order;
import com.example.onlineshopping.model.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class UserRepositoryImpl implements UserRepository, InitializingBean {
    List<User> userList;


    @Override
    public void afterPropertiesSet() throws Exception {
        userList=User.getUsers();
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userList.stream().filter(x->x.getId()==id).findFirst();
    }

    @Override
    public boolean saveUser(User user) {
        try {
            userList.add(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUserById(int id) {
        try {
            userList.remove(userList.stream().filter(x->x.getId()==id).findFirst().get());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean payForOrder(Order order) {
        if(order.getTotalPrice()>order.getUser().getBalance())
            return false;
        else {
            order.getUser().setBalance(order.getUser().getBalance()-order.getTotalPrice());
            return true;
        }
    }
}
