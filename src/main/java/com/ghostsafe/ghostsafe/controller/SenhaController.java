package com.ghostsafe.ghostsafe.controller;

import com.ghostsafe.ghostsafe.model.Senha;
import com.ghostsafe.ghostsafe.repository.SenhaRepository;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class SenhaController {

    private final SenhaRepository senhaRepository;

    public SenhaController(SenhaRepository senhaRepository) {
        this.senhaRepository = senhaRepository;
    }

    @GetMapping("/senhas")
    public List<Senha> ListarTodos() {
        return senhaRepository.findAll();
    }

    @PostMapping("/senhas")
    public Senha criar(@RequestBody Senha senha) {
        senha.setCreatedAt(LocalDateTime.now());
        return senhaRepository.save(senha);
    }

    @PutMapping("/senhas/{id}")
    public Senha atualizar(@PathVariable Integer id, @RequestBody Senha dados) {
        Senha senha = senhaRepository.findById(id).orElseThrow();
        senha.setTitulo(dados.getTitulo());
        return senhaRepository.save(senha);
    }

    @DeleteMapping("/senhas/{id}")
    public void deletar(@PathVariable Integer id){senhaRepository.deleteById(id);}
}
