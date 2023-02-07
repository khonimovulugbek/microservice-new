package com.company.orderservice.dto;

import com.company.orderservice.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author : Khonimov Ulugbek
 * Date : 2/7/2023
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private List<OrderLineItemsDTO> orderLineItemsDTOList;
}
