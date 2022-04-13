//package com.example.onlineshopping.repository.impl;
//
//import com.example.onlineshopping.model.Order;
//import com.example.onlineshopping.model.User;
//import com.example.onlineshopping.repository.UserRepository;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Primary
//@Repository
//public class UserRepositoryImpl implements UserRepository {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Override
//    public List<User> getAllUsers() {
//        return jdbcTemplate.query("select * from users ",new BeanPropertyRowMapper<>(User.class));
//    }
//
//    @Override
//    public Optional<User> getUserById(int id) {
//        return Optional.of(jdbcTemplate.queryForObject("select * from users where id=?",new Object[]{id},new BeanPropertyRowMapper<>(User.class)));
//    }
//
//    @Override
//    public boolean saveUser(User user) {
//        try {
//          jdbcTemplate.update("insert into users values(?,?,?,?)", user.getId(),user.getFullName(),user.getAddress(),user.getBalance());
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteUserById(int id) {
//        try {
//           jdbcTemplate.update("delete from users where id=?",id);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public boolean payForOrder(Order order) {
//        if(order.getTotalPrice()>order.getUser().getBalance())
//            return false;
//        else {
//            jdbcTemplate.update("update `order` set isPaid = true where id=?",order.getId());
//            jdbcTemplate.update("update users set balance = ? where id=?", order.getUser().getBalance()-order.getTotalPrice(),order.getUser().getId());
//            return true;
//        }
//    }
//}
