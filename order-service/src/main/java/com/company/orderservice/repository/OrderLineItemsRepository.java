package com.company.orderservice.repository;

import com.company.orderservice.model.OrderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineItemsRepository extends JpaRepository<OrderLineItems, Long> {
}