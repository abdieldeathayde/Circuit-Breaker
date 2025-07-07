package com.example.Circuit_Breaker.service;

import com.example.Circuit_Breaker.model.Medico;
import com.example.Circuit_Breaker.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Profile("prod")
@Service
public class ProdMedicoService {

    private final MedicoRepository medicoRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public ProdMedicoService(MedicoRepository medicoRepository, RestTemplate restTemplate) {
        this.medicoRepository = medicoRepository;
        this.restTemplate = restTemplate;
    }

    // métodos...
}