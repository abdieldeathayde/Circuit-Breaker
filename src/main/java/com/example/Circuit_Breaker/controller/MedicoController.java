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

    private final MedicoService medicoService;

    @Autowired
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> cadastrar(@RequestBody MedicoDTO medicoDTO) {
        MedicoDTO salvo = medicoService.salvar(medicoDTO);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> buscarPorId(@PathVariable Long id) {
        MedicoDTO medicoDTO = medicoService.buscarPorId(id);
        return ResponseEntity.ok(medicoDTO);
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listarTodos() {
        List<MedicoDTO> medicos = medicoService.listarTodos();
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/crm/{crm}")
    public ResponseEntity<MedicoDTO> consultarCrmExterno(@PathVariable String crm) {
        MedicoDTO medicoDTO = medicoService.consultarCrmExterno(crm);
        return ResponseEntity.ok(medicoDTO);
    }
}