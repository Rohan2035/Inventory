package com.rohan.inventory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "order_details")
@Getter
@Setter
public class Order {

    @Id
    @Column(name = "order_id")
    private Integer orderId;


    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "order_quantity")
    private Integer orderQuantity;

    @ManyToMany
    @JoinTable(
            name = "product_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
