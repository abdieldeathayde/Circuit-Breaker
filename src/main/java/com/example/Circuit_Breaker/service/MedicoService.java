package com.example.Circuit_Breaker.service;

import com.example.Circuit_Breaker.model.Medico;
import com.example.Circuit_Breaker.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public Medico salvar(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Optional<Medico> buscarPorId(Long id) {
        return medicoRepository.findById(id);
    }

    public boolean deletar(Long id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Simula consulta a um serviço externo de validação de CRM
    public Medico consultarCrm(String crm) {
        // Aqui usamos uma URL fictícia. Em ambiente real, use serviço real ou simulado
        String url = "http://localhost:8081/crm/" + crm;

        // Simula busca externa, o retorno deve ter a mesma estrutura de Medico
        return restTemplate.getForObject(url, Medico.class);
    }
}
