package com.example.demo.futebolapi.controller;

import com.example.demo.futebolapi.model.Campeonato;
import com.example.demo.futebolapi.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

    @Autowired
    private CampeonatoService service;

    @PostMapping
    public Campeonato criar(@RequestBody Campeonato campeonato) {
        return service.salvar(campeonato);
    }

    @GetMapping
    public List<Campeonato> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Campeonato buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Campeonato atualizar(@PathVariable Long id, @RequestBody Campeonato novo) {
        return service.atualizar(id, novo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}