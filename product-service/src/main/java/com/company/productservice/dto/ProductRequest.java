package com.company.productservice.dto;

import lombok.*;

import java.math.BigDecimal;

/**
 * Author : Khonimov Ulugbek
 * Date : 2/6/2023
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
}
