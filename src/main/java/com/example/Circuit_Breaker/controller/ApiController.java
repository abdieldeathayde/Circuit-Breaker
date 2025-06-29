package com.example.Circuit_Breaker.controller;

import com.example.Circuit_Breaker.service.ExternalService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ExternalService externalService;

    @GetMapping("/dados")
    @CircuitBreaker(name = "meuCircuitBreaker", fallbackMethod = "fallback")
    public String getDados() {
        return externalService.getDados();
    }

    public String fallback(Throwable t) {
        return "Fallback: Serviço fora do ar. Tente novamente mais tarde.";
    }
}
