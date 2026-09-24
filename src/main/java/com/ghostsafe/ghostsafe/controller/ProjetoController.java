package com.ghostsafe.ghostsafe.controller;

import com.ghostsafe.ghostsafe.model.Projeto;
import com.ghostsafe.ghostsafe.repository.ProjetoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProjetoController {

    private final ProjetoRepository projetoRepository;

    //o spring "entrega" o repository pronto aqui
    public ProjetoController(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    //quando acessarem /projetos,devolbe todos os projetos do banco
    @GetMapping("/projetos")
    public List<Projeto> ListarTodos() {
        return  projetoRepository.findAll();
    }


}