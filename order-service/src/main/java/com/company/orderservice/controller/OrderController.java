package com.company.orderservice.controller;

import com.company.orderservice.dto.OrderRequest;
import com.company.orderservice.model.Order;
import com.company.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Author : Khonimov Ulugbek
 * Date : 2/7/2023
 */

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }
}
