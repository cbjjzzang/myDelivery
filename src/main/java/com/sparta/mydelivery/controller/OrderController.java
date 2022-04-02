package com.sparta.mydelivery.controller;

import com.sparta.mydelivery.dto.OrderRequestDto;
import com.sparta.mydelivery.models.OrderList;
import com.sparta.mydelivery.repository.OrderRepository;
import com.sparta.mydelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/request")
    public OrderList order(@RequestBody OrderRequestDto requestDto) {

        return orderService.readOrders(requestDto);
    }

    @GetMapping("/orders")
    public List<OrderList> readOrders() {
        return orderService.findOrders();
    }
}