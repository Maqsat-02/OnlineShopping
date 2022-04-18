//package com.example.onlineshopping.document;
//
//import lombok.*;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//
//
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Builder
//@Document(indexName = "Items")
//public class Items implements Serializable {
////order-items(parent-child relationship)
//    @Id
//    @Field(type = FieldType.Integer)
//    private int id;
//
//    @Field(type = FieldType.Text)
//    private String name;
//
//    @Field(type = FieldType.Long)
//    private long price;
//
//    @Field(type = FieldType.Text)
//    private String category;
//
//
//    private Order orderId;
//
//    @Override
//    public String toString() {
//        return "Items{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", category='" + category + '\'' +
//                '}';
//    }
//}
