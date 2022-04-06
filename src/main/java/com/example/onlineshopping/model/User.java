package com.example.onlineshopping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class User {
    int id;
    String fullName;
    String address;
    long balance;

    public static List<User> getUsers() {
        User user1 = User.builder()
                .id(1)
                .fullName("Erkin Jumaliev")
                .address("st. Abdirova 123")
                .balance(500000)
                .build();

        User user2 = User.builder()
                .id(2)
                .fullName("Dias Uliashev")
                .address("st. Abay 243")
                .balance(300000)
                .build();

        User user3 = User.builder()
                .id(3)
                .fullName("Serik Ospanov")
                .address("st. Aitiev 123")
                .balance(100000)
                .build();

        return Arrays.asList(user1,user2,user3);
    }
}
