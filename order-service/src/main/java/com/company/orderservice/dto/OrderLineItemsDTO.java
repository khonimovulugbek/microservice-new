package com.company.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Author : Khonimov Ulugbek
 * Date : 2/7/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDTO {
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
