package com.rohan.inventory.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_details")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList;
}
