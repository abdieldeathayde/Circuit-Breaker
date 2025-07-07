package com.example.Circuit_Breaker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Profile;

import java.time.Duration;

@Configuration
public class AppConfig {

    @Bean
    @Profile("dev")
    public RestTemplate devRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(1000); // 1 segundo
        factory.setReadTimeout(1000); // 1 segundo
        return new RestTemplate(factory);
    }

    @Bean
    @Profile("prod")
    public RestTemplate prodRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);
        return new RestTemplate(factory);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

