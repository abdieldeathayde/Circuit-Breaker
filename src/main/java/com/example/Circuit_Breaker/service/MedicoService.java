package com.example.Circuit_Breaker.service;

import com.example.Circuit_Breaker.model.Medico;
import com.example.Circuit_Breaker.repository.MedicoRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @CircuitBreaker(name = "medicoPorCrmService", fallbackMethod = "fallbackPorCrm")
    @Retryable(
            value = {HttpClientErrorException.class},
            maxAttempts = 2,
            backoff = @Backoff(delay = 500)
    )
    public Medico consultaPorCrm(String crm) {
        return medicoRepository.findByCrm(crm)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Não encontrado"));
    }

    public Medico fallbackPorCrm(String crm, Throwable ex) {
        Medico medico = new Medico();
        medico.setCrm(crm);
        medico.setNome("Médico (fallback) não está cadastrado");
        return medico;
    }

    // Mesma lógica para ID:
    @CircuitBreaker(name = "medicoPorIdService", fallbackMethod = "fallbackPorId")
    @Retryable(value = {HttpClientErrorException.class}, maxAttempts = 2, backoff = @Backoff(delay = 500))
    public Medico consultaPorId(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Não encontrado"));
    }

    public Medico fallbackPorId(Long id, Throwable ex) {
        Medico medico = new Medico();
        medico.setId(id);
        medico.setCrm("N/A");
        medico.setNome("Médico (fallback) não está cadastrado");
        return medico;
    }
}

