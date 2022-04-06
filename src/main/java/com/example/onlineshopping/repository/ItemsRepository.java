package com.example.onlineshopping.repository;


import com.example.onlineshopping.model.Items;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemsRepository {
    List<Items> getAllItems();
    Optional<Items> getItemById(int id);
    boolean saveItem(Items item);
    boolean deleteItemById(int id);
}
