package com.example.Circuit_Breaker.service;


import com.example.Circuit_Breaker.model.Medico;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class MedicoServiceFallbackTest {

    @Autowired
    private MedicoService medicoService;

    @Test
    public void dadoIdInexistente_entaoRetornarFallback() {
        Medico m = medicoService.consultaPorId(999L);
        assertEquals("Médico não cadastrado no sistema.", m.getNome());
    }

    @Test
    public void dadoCrmInexistente_entaoRetornarFallback() {
        Medico m = medicoService.consultaPorCrm("999X");
        assertEquals("Médico não cadastrado no sistema.", m.getNome());
    }
}
