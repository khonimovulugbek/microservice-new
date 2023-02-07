package com.company.orderservice.service;

import com.company.orderservice.dto.OrderLineItemsDTO;
import com.company.orderservice.dto.OrderRequest;
import com.company.orderservice.model.Order;
import com.company.orderservice.model.OrderLineItems;
import com.company.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Author : Khonimov Ulugbek
 * Date : 2/7/2023
 */
@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;


    public void placeOrder(OrderRequest orderRequest) {
        var order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .build();
        var orderLineItems = orderRequest.getOrderLineItemsDTOList()
                .stream()
                .map(this::mapToDTO).toList();
        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);
    }

    private OrderLineItems mapToDTO(OrderLineItemsDTO dto) {
        return OrderLineItems.builder()
                .skuCode(dto.getSkuCode())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();
    }
}
