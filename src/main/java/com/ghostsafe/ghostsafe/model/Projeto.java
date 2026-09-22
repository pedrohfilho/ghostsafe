package com.ghostsafe.ghostsafe.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "projetos")
public class Projeto {

    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private String nome;

    private Boolean fixado = false;

    @Enumerated (EnumType.STRING)
    private  Estado estado = Estado.ativo;

    private LocalDateTime ultimoAcesso;

    private LocalDateTime createdAt;

    private  LocalDateTime updatedAt;

    //enum do estado (espelha o enum do banco)
    public  enum Estado {
        ativo, na_lixeira
    }

    //getters e setters


    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Boolean getFixado() { return fixado; }
    public void setFixado(Boolean fixado) {this.fixado = fixado; }

    public  Estado getEstado() { return  estado; }
    public void  setEstado(Estado estado) { this.estado = estado; }

    public LocalDateTime getUltimoAcesso() {return ultimoAcesso; }
    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {this.ultimoAcesso =  ultimoAcesso; }

    public LocalDateTime getCreatedAt() {return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() {return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt; }



}
