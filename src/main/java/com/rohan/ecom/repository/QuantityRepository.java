package com.rohan.ecom.repository;

import com.rohan.ecom.entity.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuantityRepository extends JpaRepository<Quantity, Long> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("""
        UPDATE Quantity q
        set q.reservedQuantity = q.reservedQuantity + :quantity,
        q.productQuantity = q.productQuantity - :quantity
        WHERE q.productId = :id
        AND q.productQuantity >= :quantity
    """)
    int reserveProductQuantity(@Param("id") Long productId, @Param("quantity") Integer productQuantity);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("""
        UPDATE Quantity q
        set q.reservedQuantity = q.reservedQuantity - :quantity
        WHERE q.productId = :id
        AND q.reservedQuantity >= :quantity
    """)
    int confirmProductQuantity(@Param("id") Long productId, @Param("quantity") Integer productQuantity);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("""
        UPDATE Quantity q
        set q.productQuantity = q.productQuantity + :quantity,
        q.reservedQuantity = q.reservedQuantity - :quantity
        WHERE q.productId = :id
        AND q.productQuantity >= :quantity
    """)
    int releaseProductQuantity(@Param("id") Long productId, @Param("quantity") Integer productQuantity);
}
