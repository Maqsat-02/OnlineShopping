package com.example.onlineshopping.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`order`",schema = "one_lab_db")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "orderDate", columnDefinition = "TIMESTAMP")
    private LocalDateTime orderDate;

    @Column(name = "totalPrice")
    private Long totalPrice;

    @Column(name = "isPaid")
    private Boolean isPaid;

    @Column(name = "isDelivered")
    private Boolean isDelivered;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="orderId",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Items> orderItems;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", isPaid=" + isPaid +
                ", isDelivered=" + isDelivered +
                ", user=" + user +
                ", orderItems=" + orderItems +
                '}';
    }
}
