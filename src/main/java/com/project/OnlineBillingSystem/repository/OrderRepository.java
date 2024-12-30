package com.project.OnlineBillingSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.OnlineBillingSystem.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);  // Fetch orders by User ID
}
