package com.example.demo.futebolapi.controller;


import com.example.demo.futebolapi.model.Jogador;
import com.example.demo.futebolapi.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService service;

    @PostMapping
    public Jogador criar(@RequestBody Map<String, Object> req) {
        Jogador j = new Jogador();
        j.setNome((String) req.get("nome"));
        j.setPosicao((String) req.get("posicao"));

        Long timeId = ((Number) req.get("timeId")).longValue();

        return service.salvar(j, timeId);
    }

    @GetMapping
    public List<Jogador> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Jogador buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Jogador atualizar(@PathVariable Long id, @RequestBody Jogador novo) {
        return service.atualizar(id, novo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}