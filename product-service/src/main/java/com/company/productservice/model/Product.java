package com.company.productservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.math.BigDecimal;

/**
 * Author : Khonimov Ulugbek
 * Date : 2/6/2023
 */

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
