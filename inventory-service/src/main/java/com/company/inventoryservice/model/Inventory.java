package com.company.inventoryservice.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Author : Khonimov Ulugbek
 * Date : 2/7/2023
 */



@Entity
@Table(name = "t_inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;
}
