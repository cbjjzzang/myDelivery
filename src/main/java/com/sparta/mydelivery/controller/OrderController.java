package com.sparta.mydelivery.controller;

import com.sparta.mydelivery.dto.OrderRequestDto;
import com.sparta.mydelivery.models.OrderList;
import com.sparta.mydelivery.repository.OrderRepository;
import com.sparta.mydelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/request")
    public OrderList order(@RequestBody OrderRequestDto requestDto) {
        return orderService.saveOrders(requestDto);
    }

    @GetMapping("/orders")
    public List<OrderList> readOrders() {
        return orderService.findOrders();
    }

    @PostMapping("/order/request/{x}/{y}")
    public OrderList orderDistance(@RequestBody OrderRequestDto requestDto, @PathVariable int x, @PathVariable int y) {
        return orderService.saveOrdersDistance(requestDto, x, y);
    }
}