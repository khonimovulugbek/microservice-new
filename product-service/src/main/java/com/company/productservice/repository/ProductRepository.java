package com.company.productservice.repository;

import com.company.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Author : Khonimov Ulugbek
 * Date : 2/6/2023
 */
public interface ProductRepository extends MongoRepository<Product, String> {
}
