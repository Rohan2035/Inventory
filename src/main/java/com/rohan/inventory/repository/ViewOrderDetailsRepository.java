package com.rohan.inventory.repository;

import com.rohan.inventory.entity.ViewOrder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ViewOrderDetailsRepository  {

    Optional<List<ViewOrder>> findOrders(String userEmail, LocalDateTime orderDate,
        String orderCode);
}
