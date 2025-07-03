package com.example.Circuit_Breaker.controller;

import com.example.Circuit_Breaker.model.Medico;
import com.example.Circuit_Breaker.service.MedicoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Medico> cadastrar(@RequestBody Medico medico) {
        Medico salvo = medicoService.salvar(medico);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscar(@PathVariable Long id) {
        Optional<Medico> medico = medicoService.buscarPorId(id);
        return medico.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = medicoService.deletar(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/crm/{crm}")
    @CircuitBreaker(name = "crmService", fallbackMethod = "fallbackCrm")
    public ResponseEntity<Medico> consultarCrm(@PathVariable String crm) {
        Medico medico = medicoService.consultarCrm(crm); // simula chamada externa
        return ResponseEntity.ok(medico);
    }

    public ResponseEntity<Medico> fallbackCrm(String crm, Long id, String nome, Throwable t) {
        Medico fallback = new Medico(id, nome, crm );
        fallback.setNome("Médico Desconhecido (Fallback)");
        fallback.setCrm(crm);
        return ResponseEntity.ok(fallback);
    }
}

