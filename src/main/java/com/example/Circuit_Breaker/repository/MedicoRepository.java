package com.example.Circuit_Breaker.repository;


import com.example.Circuit_Breaker.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Medico findByCrm(String crm);
    Optional<Medico> findById(Long id);
}

