package com.example.onlineshopping.repository;

import com.example.onlineshopping.model.Order;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class OrderRepositoryImpl implements OrderRepository, InitializingBean {
    List<Order> orderList;
    @Override
    public void afterPropertiesSet() throws Exception {
        orderList=Order.getOrders();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderList;
    }

    @Override
    public Optional<Order> getOrderById(int id) {
        return orderList.stream().filter(x->x.getId()==id).findFirst();
    }

    @Override
    public boolean saveOrder(Order order) {
        return orderList.add(order);
    }

    @Override
    public boolean deleteOrderById(int id) {
        try {
            orderList.remove(getOrderById(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String orderStatus(int id) {
        Order order= getOrderById(id).get();
        if(order.isPaid() && order.isDelivered()) {
            return "Your order was delivered!!";
        }
        else if(!order.isDelivered()){
            return "Please wait delivery!";
        }
        else
            return "Please, pay first for order!!";
    }

}
