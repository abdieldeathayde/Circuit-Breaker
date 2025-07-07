package com.example.Circuit_Breaker.service;

import com.example.Circuit_Breaker.model.Medico;
import com.example.Circuit_Breaker.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Profile("dev")
@Service
public class DevMedicoService {

    private final MedicoRepository medicoRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public DevMedicoService(MedicoRepository medicoRepository, RestTemplate restTemplate) {
        this.medicoRepository = medicoRepository;
        this.restTemplate = restTemplate;
    }

    public MedicoRepository getMedicoRepository() {
        return medicoRepository;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
