package com.company.orderservice.service;

import com.company.orderservice.dto.InventoryResponse;
import com.company.orderservice.dto.OrderLineItemsDTO;
import com.company.orderservice.dto.OrderRequest;
import com.company.orderservice.model.Order;
import com.company.orderservice.model.OrderLineItems;
import com.company.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.UUID;

/**
 * Author : Khonimov Ulugbek
 * Date : 2/7/2023
 */
@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    public static final String API_INVENTORY = "http://localhost:8083/api/inventory";
    private final OrderRepository orderRepository;
    private final WebClient webClient;


    public void placeOrder(OrderRequest orderRequest) {
        var order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .build();
        var orderLineItems = orderRequest.getOrderLineItemsDTOList()
                .stream()
                .map(this::mapToDTO).toList();
        order.setOrderLineItemsList(orderLineItems);

        var skuCodes = order.getOrderLineItemsList()
                .stream()
                .map(OrderLineItems::getSkuCode)
                .toList();


        // Call Inventory Service, and place order if product is on
        // stack
        var inventoryResponseArray = webClient.get()
                .uri(API_INVENTORY, uriBuilder -> uriBuilder
                        .queryParam("skuCodes", skuCodes)
                        .build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
        if (inventoryResponseArray == null) throw new RuntimeException();
        var allProductsInStock = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);
        if (allProductsInStock)
            orderRepository.save(order);
        else throw new IllegalArgumentException("Product is not in stock, please try again later");

    }

    private OrderLineItems mapToDTO(OrderLineItemsDTO dto) {
        return OrderLineItems.builder()
                .skuCode(dto.getSkuCode())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();
    }
}
