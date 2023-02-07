package com.company.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Author : Khonimov Ulugbek
 * Date : 2/7/2023
 */


@Entity
@Table(name = "t_orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;
}
