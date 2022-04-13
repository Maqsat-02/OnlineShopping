//package com.example.onlineshopping.repository.impl;
//
//import com.example.onlineshopping.model.Items;
//import com.example.onlineshopping.model.Order;
//import com.example.onlineshopping.repository.OrderRepository;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Primary
//@Repository
//public class OrderRepositoryImpl implements OrderRepository {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Override
//    public List<Order> getAllOrders() {
//        return new ArrayList<>( jdbcTemplate.query("select * from `order`",new BeanPropertyRowMapper<>(Order.class)));
//    }
//
//    @Override
//    public Optional<Order> getOrderById(int id) {
//        return Optional.of(jdbcTemplate.queryForObject("select * from `order` where id=?",new Object[]{id},new BeanPropertyRowMapper<>(Order.class)));
//    }
//
//    @Override
//    public boolean saveOrder(Order order) {
//        try {
//            jdbcTemplate.update(
//                    "insert into `order`  values(?,?,?,?,?,?)",
//                   order.getId(),order.getOrderDate(),order.getTotalPrice(),order.isPaid(),order.isDelivered(),order.getUser().getId());
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteOrderById(int id) {
//        try {
//            jdbcTemplate.update(
//                    "delete from `order` where id = ?", id);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public String orderStatus(int id) {
//        Order order= getOrderById(id).get();
//        if(order.isPaid() && order.isDelivered()) {
//            return "Your order was delivered!!";
//        }
//        else if(!order.isDelivered()){
//            return "Please wait delivery!";
//        }
//        else
//            return "Please, pay first for order!!";
//    }
//
//}
