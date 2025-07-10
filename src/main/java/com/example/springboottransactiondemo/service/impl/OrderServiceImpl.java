package com.example.springboottransactiondemo.service.impl;

import com.example.springboottransactiondemo.dto.OrderRequest;
import com.example.springboottransactiondemo.dto.OrderResponse;
import com.example.springboottransactiondemo.entity.Order;
import com.example.springboottransactiondemo.entity.Payment;
import com.example.springboottransactiondemo.repository.OrderRepository;
import com.example.springboottransactiondemo.repository.PaymentRepository;
import com.example.springboottransactiondemo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("In progress");
        order.setOrderNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if (payment.getExpireMonth() > 12 || payment.getExpireYear() < LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Wrong payment expire date");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        return new OrderResponse(order.getOrderNumber(), order.getStatus(), "IT IS ON ITs WAY TO YOU");
    }
}
