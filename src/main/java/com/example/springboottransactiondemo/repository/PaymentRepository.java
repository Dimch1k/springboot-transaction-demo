package com.example.springboottransactiondemo.repository;

import com.example.springboottransactiondemo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
