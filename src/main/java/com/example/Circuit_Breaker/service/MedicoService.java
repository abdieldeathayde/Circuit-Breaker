package com.example.Circuit_Breaker.service;

import com.example.Circuit_Breaker.dtos.MedicoDTO;
import com.example.Circuit_Breaker.model.Medico;
import com.example.Circuit_Breaker.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;
    private final RestTemplate restTemplate;


    public MedicoService(MedicoRepository medicoRepository, RestTemplate restTemplate) {
        this.medicoRepository = medicoRepository;
        this.restTemplate = restTemplate;
    }

    public MedicoDTO salvar(MedicoDTO medicoDTO) {
        Medico medico = medicoDTO.toEntity();
        medico = medicoRepository.save(medico);
        return MedicoDTO.from(medico);
    }

    public Optional<Medico> buscarPorId(Long id) {

        return medicoRepository.findById(id);
    }

    public List<MedicoDTO> listarTodos() {
        List<Medico> medicos = medicoRepository.findAll();
        return medicos.stream().map(MedicoDTO::from).collect(Collectors.toList());
    }

    public Medico consultarCrmExterno(String crm) {
        String url = "http://localhost:9090/servico-externo/crm/" + crm;
        Medico medico = restTemplate.getForObject(url, Medico.class);
        return medicoRepository.findByCrm(crm);
    }
}
