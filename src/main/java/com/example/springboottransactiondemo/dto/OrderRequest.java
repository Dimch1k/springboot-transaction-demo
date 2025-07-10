package com.example.springboottransactiondemo.dto;

import com.example.springboottransactiondemo.entity.Order;
import com.example.springboottransactiondemo.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Order order;
    private Payment payment;
}
