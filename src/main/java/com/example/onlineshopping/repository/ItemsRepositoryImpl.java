package com.example.onlineshopping.repository;

import com.example.onlineshopping.model.Items;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class ItemsRepositoryImpl implements ItemsRepository, InitializingBean {
    List<Items> itemsList;
    @Override
    public List<Items> getAllItems() {
        return itemsList;
    }

    @Override
    public Optional<Items> getItemById(int id) {
        return itemsList.stream()
                .filter(item -> item.getId()==(id))
                .findFirst();
    }

    @Override
    public boolean saveItem(Items item) {
        try {
            itemsList.add(item);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteItemById(int id) {
        try {
            itemsList.remove(itemsList.stream()
                    .filter(item -> item.getId()==id).findFirst().get());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        itemsList=Items.getItems();
    }
}
