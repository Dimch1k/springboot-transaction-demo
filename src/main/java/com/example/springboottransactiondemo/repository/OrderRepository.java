package com.example.springboottransactiondemo.repository;

import com.example.springboottransactiondemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
