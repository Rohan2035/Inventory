package com.rohan.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_details")
@Data
public class ViewOrder {

    @Id
    @Column(name = "ORDER_ID")
    private Integer orderId;

    @Column(name = "ORDER_CD")
    private String orderCode;

    @Column(name = "ORDER_DATE")
    private LocalDateTime orderDate;

    @Column(name = "PRODUCT_PRICE")
    private BigDecimal productPrice;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
