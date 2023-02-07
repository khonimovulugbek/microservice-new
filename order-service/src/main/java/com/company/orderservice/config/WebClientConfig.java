package com.company.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Author : Khonimov Ulugbek
 * Date : 2/7/2023
 */

@Configuration
public class WebClientConfig {

    //
    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
