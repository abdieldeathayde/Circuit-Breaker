package com.example.Circuit_Breaker.service;

import org.springframework.stereotype.Service;

@Service
public class ExternalService {

    public String getDados() {
        if (Math.random() < 0.7) {
            throw new RuntimeException("Serviço externo falhou!");
        }
        return "Dados do serviço externo.";
    }
}

