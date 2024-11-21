package org.example.orderservice.repo;


import org.example.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface OrderRepo extends JpaRepository<Order, Long> {
    // Custom query to find orders by customer ID
    List<Order> findByCustomerId(Long customerId);
}
