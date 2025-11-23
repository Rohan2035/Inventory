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

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_first_name")
    private String firstName;

    @Column(name = "user_last_name")
    private String userLastName;

    @Column(name = "user_password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList;
}
