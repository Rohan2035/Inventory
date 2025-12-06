package com.rohan.inventory.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "order_details")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Integer orderId;

    @Column(name = "ORDER_CD")
    private String orderCode;

    @Column(name = "ORDER_DATE")
    private String orderDate;

    @Column(name = "PRODUCT_QUANTITY")
    private Integer productQuantity;

    @Column(name = "USER_LOCATION")
    private String userLocation;

    @Column(name = "PRODUCT_PRICE")
    private String productPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void generateUniqueCode() {
        if(!StringUtils.hasLength(this.orderCode)) {
            this.orderCode = UUID.randomUUID().toString();
        }
    }
}
