package com.ghostsafe.ghostsafe.controller;

import com.ghostsafe.ghostsafe.model.Projeto;
import com.ghostsafe.ghostsafe.repository.ProjetoRepository;
//o * importa todas as anotaçoes web de uma vez
import  org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
public class ProjetoController {

    private final ProjetoRepository projetoRepository;

    //referencia ao repository, que faz a convesar com o banco
    public ProjetoController(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    //O Spring "injeta" o repository pronto aqui automaticamente
    @GetMapping("/projetos")
    public List<Projeto> ListarTodos() {
        // méto/do pronto do repository, faz o SELECT de todos
        return  projetoRepository.findAll();
    }

    //CREATE(criar)
    //CRIAR um projeto novo, mesma URL /projetos, mas responde ao metodo post
    @PostMapping("/projetos")
    //@RequestBody: pega o JSON enviado e transforma num objeto Projeto
    public Projeto criar(@RequestBody Projeto projeto) {
        //preenche as datas na hora da criaçao
        projeto.setCreatedAt(LocalDateTime.now());
        projeto.setUltimoAcesso(LocalDateTime.now());
        //mét/odo pronto do repository, faz o INSERT e devolve com o id gerado
        return  projetoRepository.save(projeto);
    }
    //UPDATE(atualizar)
    // o {id} é um trecho variavel da url
    @PutMapping("/projetos/{id}")
    public  Projeto atualizar(@PathVariable Integer id, @RequestBody Projeto dados) {
        Projeto projeto = projetoRepository.findById(id).orElseThrow();
        projeto.setNome(dados.getNome());
        projeto.setFixado(dados.getFixado());
        projeto.setUpdatedAt(LocalDateTime.now());
        return projetoRepository.save(projeto);
    }
    //DELETE(apagar)
    @DeleteMapping("/projetos/{id}")
    public void  deletar(@PathVariable Integer id) {
        projetoRepository.deleteById(id);
    }


}