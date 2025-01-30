package com.btcag.bootcamp2024.RobotWarsClient.Services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//Diese Klasse stellt RestTemplate Bean / Konfiguration bereit

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
