//package com.example.onlineshopping.repository.impl;
//
//import com.example.onlineshopping.model.Items;
//import com.example.onlineshopping.repository.ItemsRepository;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.dao.DataAccessException;
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
//public class ItemsRepositoryImpl implements ItemsRepository {
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Override
//    public List<Items> getAllItems() {
//        return new ArrayList<>( jdbcTemplate.query("select * from items",new BeanPropertyRowMapper<>(Items.class)));
//    }
//
//    @Override
//    public Optional<Items> getItemById(int id) {
//        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from items where id=?",new Object[]{id}, new BeanPropertyRowMapper<>(Items.class)));
//    }
//
//    @Override
//    public boolean saveItem(Items item) {
//
//        try {
//            jdbcTemplate.update(
//                    "insert into items (id,name, price,category) values(?,?,?,?)",
//                  item.getId(),item.getName(),item.getPrice(),item.getCategory());
//            return true;
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//
//
//    @Override
//    public boolean deleteItemById(int id) {
//        try {
//             jdbcTemplate.update("delete from items where id = ?", id);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//}
