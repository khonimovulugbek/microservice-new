package com.company.inventoryservice.controller;

import com.company.inventoryservice.dto.InventoryResponse;
import com.company.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author : Khonimov Ulugbek
 * Date : 2/7/2023
 */
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam("skuCodes") List<String> skuCodes) {
        return inventoryService.isInStock(skuCodes);
    }
}
