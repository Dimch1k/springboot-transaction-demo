package com.example.springboottransactiondemo.service;

import com.example.springboottransactiondemo.dto.OrderRequest;
import com.example.springboottransactiondemo.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest order);
}
