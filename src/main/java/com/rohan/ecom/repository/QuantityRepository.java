package com.rohan.ecom.repository;

import com.rohan.ecom.entity.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuantityRepository extends JpaRepository<Quantity, Integer> {
}
