package com.example.Circuit_Breaker.controller;

import com.example.Circuit_Breaker.dtos.MedicoDTO;
import com.example.Circuit_Breaker.model.Medico;
import com.example.Circuit_Breaker.service.MedicoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping("/id/{id}")
    public ResponseEntity<Medico> buscarPorId(@PathVariable Long id) {
        Medico medico = medicoService.consultaPorId(id);
        return ResponseEntity.ok(medico);
    }

    @GetMapping("/crm/{crm}")
    public ResponseEntity<Medico> buscarPorCrm(@PathVariable String crm) {
        Medico medico = medicoService.consultaPorCrm(crm);
        return ResponseEntity.ok(medico);
    }

    @PostMapping
    public ResponseEntity<Medico> cadastrar(@RequestBody Medico medico) {
        Medico salvo = medicoService.salvar(medico);
        return ResponseEntity.ok(salvo);
    }
}
