//package com.example.onlineshopping.document;
//
//import com.example.onlineshopping.model.User;
//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
//import lombok.*;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//import org.springframework.data.elasticsearch.annotations.InnerField;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Document(indexName = "Order")
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
//public class Order implements Serializable {
////order-user(inner object)
//    @Id
//   @Field(type = FieldType.Integer)
//    private Integer id;
//
//    @Field(name = "@timestamp", type = FieldType.Date)
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    private LocalDateTime orderDate;
//
//    @Field(type = FieldType.Long)
//    private Long totalPrice;
//
//    @Field(type = FieldType.Boolean)
//    private Boolean isPaid;
//
//    @Field(type = FieldType.Boolean)
//    private Boolean isDelivered;
//
//    private User user;
//
//
//    private List<Items> orderItems;
//
//    @Override
//    public String toString() {
//        return "Order{" +
//                "id=" + id +
//                ", orderDate=" + orderDate +
//                ", totalPrice=" + totalPrice +
//                ", isPaid=" + isPaid +
//                ", isDelivered=" + isDelivered +
//                ", user=" + user +
//                ", orderItems=" + orderItems +
//                '}';
//    }
//}
