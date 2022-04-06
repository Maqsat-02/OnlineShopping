package com.example.onlineshopping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//import java.util.Arrays;
//import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class Items {
    int id;
    String name;
    long price;
    String category;

    public static List<Items> getItems() {
        Items items1 = Items.builder()
                .id(1)
                .name("IPHONE X 256GB")
                .price(485990)
                .category("Smartphones")
                .build();

        Items items2 = Items.builder()
                .id(2)
                .name("SAMSUNG GALAXY S8 64GB")
                .price(253990)
                .category("Smartphones")
                .build();

        Items items3 = Items.builder()
                .id(3)
                .name("IPHONE 7 128GB SILVER 256GB")
                .price(279990)
                .category("Smartphones")
                .build();

        Items items4 = Items.builder()
                .id(4)
                .name("XIAOMI REDMI NOTE 3 32GB")
                .price(105990)
                .category("Smartphones")
                .build();

        Items items5 = Items.builder()
                .id(5)
                .name("Samsung Galaxy Note 8 64GB")
                .price(349990)
                .category("Smartphones")
                .build();

        return Arrays.asList(items1,items2,items3,items4,items5);
    }
}
