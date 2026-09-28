package com.ghostsafe.ghostsafe.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "senhas")
public class Senha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private String titulo;

    @Enumerated (EnumType.STRING)
    private Estado estado = Estado.ativo;

    @Column(name = "valor_cifrado", nullable = false)
    private String valorCifrado;


    private LocalDateTime createdAt;


    public enum Estado {
        ativo, na_lixeira
    }

    public Integer getId() {return id; }
    public void setId(Integer id) {this.id = id; }

    public  String getTitulo() {return titulo; }
    public void setTitulo(String titulo) {this.titulo = titulo; }

    public Estado getEstado() {return estado; }
    public void  setEstado(Estado estado) {this.estado = estado; }

    public String getValorCifrado() {return valorCifrado; }
    public void setValorCifrado(String valorCifrado) {this.valorCifrado = valorCifrado; }


    public LocalDateTime getCreatedAt() {return  createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt; }


}
