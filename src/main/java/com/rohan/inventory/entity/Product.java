package com.rohan.inventory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "product_details")
@Getter
@Setter
public class Product {

    @Id
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_category")
    private String productCategory;

    @Column(name = "product_price")
    private String productPrice;

    @Column(name = "product_quantity")
    private Integer productQuantity;

    @ManyToMany(mappedBy = "productList")
    private List<Order> orderList;
}
