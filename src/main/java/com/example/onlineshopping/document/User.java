//package com.example.onlineshopping.document;
//
//import lombok.*;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Builder
//@Document(indexName = "User")
//public class User implements Serializable {
//    @Id
//    @Field(type = FieldType.Integer)
//    private Integer id;
//
//    @Field(type = FieldType.Text)
//    private String fullName;
//
//    @Field(type = FieldType.Text)
//    private String address;
//
//    @Field(type = FieldType.Long)
//    private Long balance;
//
//
//    private Order order;
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", fullName='" + fullName + '\'' +
//                ", address='" + address + '\'' +
//                ", balance=" + balance +
//                '}';
//    }
//}
