package com.example.Circuit_Breaker.service;

import com.example.Circuit_Breaker.model.Medico;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class MedicoConsultaServiceFallback implements MedicoConsultaService {
    @Override
    public Medico consultarCrm(String crm) {
        Medico medico = new Medico();
        medico.setCrm(crm);
        medico.setNome("Fallback: Médico não encontrado.");
        return medico;
    }
}
