package com.example.Circuit_Breaker.service;

import com.example.Circuit_Breaker.model.Medico;
import com.example.Circuit_Breaker.repository.MedicoRepository;
import com.example.Circuit_Breaker.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevMedicoService extends MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public Medico consultaPorCrm(String crm) {
        // fallback ou comportamento alternativo no profile dev
        Medico medico = new Medico();
        medico.setNome("Dr. Dev Fallback");
        medico.setCrm(crm);
        return medicoRepository.save(medico);
    }

    @Override
    public Medico consultaPorId(Long id) {
        Medico medico = new Medico();
        medico.setId(id);
        medico.setNome("Médico Fallback Dev");
        medico.setCrm("0000-DEV");
        return medico;
    }
}
