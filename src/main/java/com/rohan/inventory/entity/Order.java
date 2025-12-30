package com.rohan.inventory.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "order_details")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Integer orderId;

    @Column(name = "ORDER_CD", unique = true)
    private String orderCode;

    @Column(name = "ORDER_DATE")
    private LocalDateTime orderDate;

    @Column(name = "PRODUCT_QUANTITY")
    private Integer productQuantity;

    @Column(name = "PRODUCT_PRICE")
    private BigDecimal productPrice;

    @Column(name = "product_id")
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void generateUniqueCode() {
        if(!StringUtils.hasLength(this.orderCode)) {
            this.orderCode = UUID.randomUUID().toString()
                    .substring(0, 6)
                    .replace("_", "");
        }
    }
}
