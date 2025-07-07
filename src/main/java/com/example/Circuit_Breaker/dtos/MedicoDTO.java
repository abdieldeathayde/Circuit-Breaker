package com.example.Circuit_Breaker.dtos;

import com.example.Circuit_Breaker.model.Medico;

public class MedicoDTO {
    private Long id;
    private String nome;
    private String crm;

    public MedicoDTO() {}

    public MedicoDTO(Medico medico) {
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.crm = medico.getCrm();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public static MedicoDTO from(Medico medico) {
        return new MedicoDTO(medico);
    }

    public Medico toEntity() {
        Medico medico = new Medico();
        medico.setId(this.id);
        medico.setNome(this.nome);
        medico.setCrm(this.crm);
        return medico;
    }
}
